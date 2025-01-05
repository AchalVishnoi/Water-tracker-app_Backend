package com.Achal.Water.tracker.app.models;

public class WaterTimeline {

    private String time;    // Time of water intake (e.g., "09:00 AM")
    private double amount;  // Amount of water consumed in ml

    // Constructor
    public WaterTimeline(String time, double amount) {
        this.time = time;
        this.amount = amount;
    }

    // Getters and Setters
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
