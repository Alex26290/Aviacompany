package org.aviacompany.model;

import javax.persistence.*;

@Entity
@Table(name = "test_flights")
public class TestFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int flight_number;
    private String departure_city;
    private String arrival_city;
    private String departure_airport;
    private String arrival_airport;

    public TestFlight() {
    }

    public TestFlight(String departure_city, String arrival_city) {
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
    }

    public TestFlight(long id, String departure_city, String arrival_city) {
        this.id = id;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
    }

    public TestFlight(long id, int flight_number, String departure_city, String arrival_city, String departure_airport, String arrival_airport) {
        this.id = id;
        this.flight_number = flight_number;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    @Override
    public String toString() {
        return "TestFlight{" +
                "id=" + id +
                ", departure_city='" + departure_city + '\'' +
                ", arrival_city='" + arrival_city + '\'' +
                '}';
    }
}
