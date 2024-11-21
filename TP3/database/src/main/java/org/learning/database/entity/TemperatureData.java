package org.learning.database.entity;

import jakarta.persistence.*;

@Entity
@Table (name ="temperature")
public class TemperatureData {
    @Id
    private String sensorId ;
    private float temperature ;

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
