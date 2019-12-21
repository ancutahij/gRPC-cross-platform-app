package model;

import model.HasID;

import java.io.Serializable;
import java.time.LocalTime;

public class Journey implements HasID<String>, Serializable {
    private String id;
    private String touristiObjective;
    private String transportCompany;
    private LocalTime departureTime;
    private double price;
    private int noAvailableSeats;

    public Journey(String id, String touristiObjective, String transportCompany, LocalTime departureTime, double price, int noAvailableSeats) {
        this.id = id;
        this.touristiObjective = touristiObjective;
        this.transportCompany = transportCompany;
        this.departureTime = departureTime;
        this.price = price;
        this.noAvailableSeats = noAvailableSeats;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void setID(String newID) {
        id= newID;
    }

    public String getTouristiObjective() {
        return touristiObjective;
    }

    public void setTouristiObjective(String touristiObjective) {
        this.touristiObjective = touristiObjective;
    }

    public String getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(String transportCompany) {
        this.transportCompany = transportCompany;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoAvailableSeats() {
        return noAvailableSeats;
    }

    public void setNoAvailableSeats(int noAvailableSeats) {
        this.noAvailableSeats = noAvailableSeats;
    }

    @Override
    public String toString() {
        return "model.Journey{" +
                "id='" + id + '\'' +
                ", touristiObjective='" + touristiObjective + '\'' +
                ", transportCompany='" + transportCompany + '\'' +
                ", departureTime=" + departureTime +
                ", price=" + price +
                ", noAvailableSeats=" + noAvailableSeats +
                '}';
    }
}
