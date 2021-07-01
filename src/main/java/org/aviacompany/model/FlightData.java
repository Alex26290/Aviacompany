package org.aviacompany.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("org.aviacompany")
public class FlightData {

private int id;
private String departureCity;

    public FlightData() {
    }

    public FlightData(int id, String departureCity) {
        this.id = id;
        this.departureCity = departureCity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "id=" + id +
                ", departureCity='" + departureCity + '\'' +
                '}';
    }
}
