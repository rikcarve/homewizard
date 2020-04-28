package ch.carve.homewizard;

import ch.carve.homewizard.model.TemperatureSensor;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

@ApplicationScoped
public class TemperatureService {

    @Inject
    @RestClient
    HomewizardClient homewizardClient;

    @Traced
    @Retry(maxRetries = 1)
    public CompletionStage<TemperatureSensor> getSensorAsync(int id) {
        Logger.getLogger("here").info(() -> "getSensor");
        return homewizardClient.getTemperatur()
                .exceptionally(ex -> {
                    throw new RuntimeException("Something went wrong", ex);
                })
                .thenApply(t -> t.getSensor().get(id));
    }

    @Traced
    @Retry(maxRetries = 1)
    public TemperatureSensor getSensor(int id) {
        Logger.getLogger("here").info(() -> "getSensor");
        return homewizardClient.getTemperaturSync().getSensor().get(id);
    }

    @Traced
    @Retry(maxRetries = 1)
    public List<TemperatureSensor> getList() {
        return homewizardClient.getTemperaturSync().getSensor();
    }

}
