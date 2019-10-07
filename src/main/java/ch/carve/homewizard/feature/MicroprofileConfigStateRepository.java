package ch.carve.homewizard.feature;

import java.util.Arrays;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.togglz.core.Feature;
import org.togglz.core.repository.FeatureState;
import org.togglz.core.repository.StateRepository;

public class MicroprofileConfigStateRepository implements StateRepository {

    @Override
    public FeatureState getFeatureState(Feature feature) {
        Config config = ConfigProvider.getConfig();
        String prefix = feature.name() + "_";
        FeatureState featureState = new FeatureState(feature);
        featureState.setEnabled(config.getOptionalValue(prefix + "ENABLED", Boolean.class).orElse(false));
        featureState.setStrategyId(config.getOptionalValue(prefix + "STRATEGY_ID", String.class).orElse(""));
        String params = config.getOptionalValue(prefix + "STRATEGY_PARAMS", String.class).orElse("");
        Arrays.stream(params.split(";"))
                .map((p) -> p.split("="))
                .filter((m) -> m.length > 1)
                .forEach((m) -> featureState.setParameter(m[0], m[1]));
        return featureState;
    }

    @Override
    public void setFeatureState(FeatureState featureState) {
        // do nothing
    }

}
