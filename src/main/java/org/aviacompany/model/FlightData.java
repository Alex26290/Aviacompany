package org.aviacompany.model;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("org.aviacompany")
public class FlightData {

private String departure_city;

    public FlightData() {
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "departure_city='" + departure_city + '\'' +
                '}';
    }

}
