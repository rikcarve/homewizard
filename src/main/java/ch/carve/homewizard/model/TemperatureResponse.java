package ch.carve.homewizard.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
public class TemperatureResponse {
    private String status;
    private String version;
    private Request request;
    @JsonbProperty("response")
    private ArrayList<TemperatureSensor> sensor = new ArrayList<>();
}
