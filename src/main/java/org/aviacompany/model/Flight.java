package org.aviacompany.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int flight_number;
    private String departure_city;
    private String arrival_city;
    private String departure_airport;
    private String arrival_airport;
    private Date departure_date;
    private Date arrival_date;

    public Flight() {
    }

    public Flight(String departure_city, String arrival_city) {
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
    }

    public Flight(long id, String departure_city, String arrival_city) {
        this.id = id;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
    }

    public Flight(String departure_city, String arrival_city, Date departure_date, Date arrival_date) {
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
    }

    public Flight(long id, int flight_number, String departure_city, String arrival_city, String departure_airport, String arrival_airport) {
        this.id = id;
        this.flight_number = flight_number;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
    }

    public Flight(long id, int flight_number, String departure_city, String arrival_city, String departure_airport, String arrival_airport, Date departure_date, Date arrival_date) {
        this.id = id;
        this.flight_number = flight_number;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.departure_date = departure_date;
        this.arrival_date = arrival_date;
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

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flight_number=" + flight_number +
                ", departure_city='" + departure_city + '\'' +
                ", arrival_city='" + arrival_city + '\'' +
                ", departure_airport='" + departure_airport + '\'' +
                ", arrival_airport='" + arrival_airport + '\'' +
                ", departure_date=" + departure_date +
                ", arrival_date=" + arrival_date +
                '}';
    }
}
