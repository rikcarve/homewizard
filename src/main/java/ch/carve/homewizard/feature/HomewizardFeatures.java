package ch.carve.homewizard.feature;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum HomewizardFeatures implements Feature {

    @Label("Feature1")
    FEATURE_ONE,

    @Label("Feature 2")
    FEATURE_TWO;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
