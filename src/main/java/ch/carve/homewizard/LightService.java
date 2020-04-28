package ch.carve.homewizard;

import ch.carve.homewizard.model.Switch;
import ch.carve.homewizard.model.SwitchToggleResponse;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;

@ApplicationScoped
public class LightService {
    @Inject
    @RestClient
    HomewizardClient homewizardClient;

    @Traced
    @Retry(maxRetries = 1)
    public ArrayList<Switch> getList() {
        return homewizardClient.getSwitchList().getSensor();
    }

    @Traced
    @Retry(maxRetries = 1)
    public SwitchToggleResponse toggle(int id, String status) {
        return homewizardClient.switchToggle(id, status);
    }

}
