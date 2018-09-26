package ch.carve.homewizard;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.eclipse.microprofile.config.inject.ConfigProperty;

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
    private String homewizardUrl;

    @PostConstruct
    public void init() {
        client = ClientBuilder
                .newBuilder()
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .build();
    }
    
    public TemperaturSensor getSensor(int id) {
        TemperaturResponse response = client.target(homewizardUrl)
                .path("/telist")
                .request()
                .get(TemperaturResponse.class);
            return response.getSensor().get(id);
    }
}
