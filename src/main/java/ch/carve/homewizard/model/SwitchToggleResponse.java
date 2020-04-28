package ch.carve.homewizard.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SwitchToggleResponse {
    private String status;
    private String version;
    private Request request;
}
