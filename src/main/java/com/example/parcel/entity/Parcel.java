package com.example.parcel.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "parcels")
public class Parcel {

    @Id
    private String trackingId;
    private String sender;
    private String receiver;
    private String origin;
    private String destination;
    private String status;

    public Parcel() {}

    public Parcel(String trackingId, String sender, String receiver, String origin, String destination, String status) {
        this.trackingId = trackingId;
        this.sender = sender;
        this.receiver = receiver;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
    }

    public String getTrackingId() { return trackingId; }
    public void setTrackingId(String trackingId) { this.trackingId = trackingId; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getReceiver() { return receiver; }
    public void setReceiver(String receiver) { this.receiver = receiver; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

