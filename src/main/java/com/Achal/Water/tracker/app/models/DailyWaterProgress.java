package com.Achal.Water.tracker.app.models;

import java.time.LocalDate;
import java.util.List;

public class DailyWaterProgress {

    private LocalDate date;
    private double target;
    private double consumed;
    private double remaining;
    private double progressPercentage;
    private List<WaterTimeline> timeline;

    // Constructor
    public DailyWaterProgress(LocalDate date, double target, double consumed,
                              double remaining, double progressPercentage,
                              List<WaterTimeline> timeline) {
        this.date = date;
        this.target = target;
        this.consumed = consumed;
        this.remaining = remaining;
        this.progressPercentage = progressPercentage;
        this.timeline = timeline;
    }

    // Getters and Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public List<WaterTimeline> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<WaterTimeline> timeline) {
        this.timeline = timeline;
    }
}
