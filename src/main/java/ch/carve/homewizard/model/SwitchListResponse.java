package ch.carve.homewizard.model;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;
import java.util.ArrayList;

@Getter
@Setter
public class SwitchListResponse {
    private String status;
    private String version;
    private Request request;
    @JsonbProperty("response")
    private ArrayList<Switch> sensor = new ArrayList<>();
}
