package ch.carve.homewizard.model;

import java.util.ArrayList;

public class TemperaturResponse {
    private String status;
    private String version;
    private Request request;
    private ArrayList<TemperaturSensor> sensor = new ArrayList<>();
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public Request getRequest() {
        return request;
    }
    public void setRequest(Request request) {
        this.request = request;
    }
    public ArrayList<TemperaturSensor> getSensor() {
        return sensor;
    }
    public void setSensor(ArrayList<TemperaturSensor> sensor) {
        this.sensor = sensor;
    }
}
