package com.Achal.Water.tracker.app.response;

public class WaterIntakeResponse {

    private String message;
    private double target;
    private double consumed;
    private double remaining;
    private double progress;

    // Constructor
    public WaterIntakeResponse(String message, double target, double consumed,
                               double remaining, double progress) {
        this.message = message;
        this.target = target;
        this.consumed = consumed;
        this.remaining = remaining;
        this.progress = progress;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getConsumed() {
        return consumed;
    }

    public void setConsumed(double consumed) {
        this.consumed = consumed;
    }

    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}

