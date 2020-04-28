package ch.carve.homewizard.model;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureSensor {
    private float id;
    private String name;
    private String code;
    private float model;
    private String lowBattery;
    private float version;
    @JsonbProperty("te")
    private float temperature;
    @JsonbProperty("hu")
    private float humidity;
    @JsonbProperty("te+")
    private float teMax;
    @JsonbProperty("te+t")
    private String teMaxTime;
    @JsonbProperty("te-")
    private float teMin;
    @JsonbProperty("te-t")
    private String teMinTime;
    @JsonbProperty("hu+")
    private float huMax;
    @JsonbProperty("hu+t")
    private String huMaxTime;
    @JsonbProperty("hu-")
    private float huMin;
    @JsonbProperty("hu-t")
    private String huMinTime;
    private String outside;
    private String favorite;

}
