package ch.carve.homewizard.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperaturResponse {
    private String status;
    private String version;
    private Request request;
    private ArrayList<TemperaturSensor> sensor = new ArrayList<>();
}
