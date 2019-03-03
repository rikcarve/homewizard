package ch.carve.homewizard;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.opentracing.Traced;

import ch.carve.homewizard.model.TemperaturResponse;
import ch.carve.homewizard.model.TemperaturSensor;

@ApplicationScoped
public class TemperaturService {
    private Client client;

    @Inject
    @ConfigProperty(name = "homewizard.connectTimeoutMs", defaultValue = "3000")
    private Integer connectTimeout;

    @Inject
    @ConfigProperty(name = "homewizard.readTimeoutMs", defaultValue = "2000")
    private Integer readTimeout;

    @Inject
    @ConfigProperty(name = "homewizard.url")
    private Provider<String> homewizardUrl;

    @PostConstruct
    public void init() {
        client = ClientBuilder
                .newBuilder()
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .build();
    }
    
    @Traced
    @Retry(maxRetries = 1)
    public CompletionStage<TemperaturSensor> getSensor(int id) {
        Logger.getLogger("here").info(() -> "getSensor");
        return client.target(homewizardUrl.get())
                .path("/telist")
                .request()
                .rx()
                .get(TemperaturResponse.class)
                .exceptionally(ex -> {throw new RuntimeException("Bla");})
                .thenApply(t -> t.getSensor().get(id));
    }
}
