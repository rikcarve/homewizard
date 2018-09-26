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

    public String getVersion() {
        return version;
    }

    public Request getRequest() {
        return request;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setRequest(Request requestObject) {
        this.request = requestObject;
    }

    public ArrayList<TemperaturSensor> getSensor() {
        return sensor;
    }

    public void setResponse(ArrayList<TemperaturSensor> sensor) {
        this.sensor = sensor;
    }

}
