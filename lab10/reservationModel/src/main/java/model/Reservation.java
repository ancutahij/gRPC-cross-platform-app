package model;

import model.HasID;
import model.Journey;

import java.io.Serializable;

public class Reservation implements HasID<String>, Serializable {
    private String id;
    private String customerName;
    private String phoneNumber;
    private int noTickets;
    private Journey journey;

    public Reservation(String id, String customerName, String phoneNumber, int noTickets, Journey journey) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.noTickets = noTickets;
        this.journey = journey;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public void setID(String newID) {
        id= newID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNoTickets() {
        return noTickets;
    }

    public void setNoTickets(int noTickets) {
        this.noTickets = noTickets;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }
}
