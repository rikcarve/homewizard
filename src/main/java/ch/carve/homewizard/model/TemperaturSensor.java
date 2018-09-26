package ch.carve.homewizard.model;

import javax.json.bind.annotation.JsonbProperty;

public class TemperaturSensor {
    private float id;
    private String name;
    private String code;
    private float model;
    private String lowBattery;
    private float version;
    @JsonbProperty("te")
    private float temperatur;
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

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public float getModel() {
        return model;
    }

    public String getLowBattery() {
        return lowBattery;
    }

    public float getVersion() {
        return version;
    }

    public float getTemperatur() {
        return temperatur;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTeMax() {
        return teMax;
    }

    public String getTeMaxTime() {
        return teMaxTime;
    }

    public float getTeMin() {
        return teMin;
    }

    public String getTeMinTime() {
        return teMinTime;
    }

    public float getHuMax() {
        return huMax;
    }

    public String getHuMaxTime() {
        return huMaxTime;
    }

    public float getHuMin() {
        return huMin;
    }

    public String getHuMinTime() {
        return huMinTime;
    }

    public String getOutside() {
        return outside;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setModel(float model) {
        this.model = model;
    }

    public void setLowBattery(String lowBattery) {
        this.lowBattery = lowBattery;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public void setTemperatur(float te) {
        this.temperatur = te;
    }

    public void setHumidity(float hu) {
        this.humidity = hu;
    }

    public void setTeMax(float teMax) {
        this.teMax = teMax;
    }

    public void setTeMaxTime(String teMaxTime) {
        this.teMaxTime = teMaxTime;
    }

    public void setTeMin(float teMin) {
        this.teMin = teMin;
    }

    public void setTeMinTime(String teMinTime) {
        this.teMinTime = teMinTime;
    }

    public void setHuMax(float huMax) {
        this.huMax = huMax;
    }

    public void setHuMaxTime(String huMaxTime) {
        this.huMaxTime = huMaxTime;
    }

    public void setHuMin(float huMin) {
        this.huMin = huMin;
    }

    public void setHuMinTime(String huMinTime) {
        this.huMinTime = huMinTime;
    }

    public void setOutside(String outside) {
        this.outside = outside;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }
}
