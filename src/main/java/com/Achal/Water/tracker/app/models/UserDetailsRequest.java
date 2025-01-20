package com.Achal.Water.tracker.app.models;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public class UserDetailsRequest {

    private int userId;

    private String gender;
    private int age;
    private double weight;
    @JsonFormat(pattern = "hh:mm a")
    private LocalTime wakeUpTime;
    @JsonFormat(pattern = "hh:mm a")
    private LocalTime sleepTime;

    private double height;

    // Getters and Setters
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalTime getWakeUpTime() {
        return wakeUpTime;
    }

    public void setWakeUpTime(LocalTime wakeUpTime) {
        this.wakeUpTime = wakeUpTime;
    }

    public LocalTime getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(LocalTime sleepTime) {
        this.sleepTime = sleepTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
