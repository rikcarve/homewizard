package ch.carve.homewizard.feature;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.user.NoOpUserProvider;

@ApplicationScoped
public class FeatureManagerProducer {

    @Produces
    @ApplicationScoped
    public FeatureManager getFeatureManager() {
        return new FeatureManagerBuilder()
                .featureEnum(HomewizardFeatures.class)
                .stateRepository(new MicroprofileConfigStateRepository())
                .userProvider(new NoOpUserProvider())
                .build();
    }

}
