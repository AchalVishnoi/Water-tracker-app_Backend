package com.Achal.Water.tracker.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email; // Unique constraint for email

    private int age;

   // @Enumerated(EnumType.STRING)            //first i have used here enum for gender selection but as i am doing frontend and backend both so i will keep track of coreect details without problem
    private String gender;
    @JsonFormat(pattern = "hh:mm a")
    private LocalTime wakeUpTime;
    @JsonFormat(pattern = "hh:mm a")
    private LocalTime sleepTime;

    private double weight;

    private String password;

    private boolean isVerified = false; // To track email verification status

    private boolean detailsComplete=false;

    private double height;

    private double bmi;


    public void setDetailsComplete(boolean detailsComplete) {
        this.detailsComplete = detailsComplete;
    }

    public User() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isDetailsComplete() {
        return detailsComplete;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public User(Long id, String firstName, String lastName, String email, int age, String gender, LocalTime wakeUpTime, LocalTime sleepTime, double weight, String password, boolean isVerified, boolean detailsComplete,double height,double bmi
                ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.gender = gender;

        this.wakeUpTime = wakeUpTime;

        this.sleepTime = sleepTime;
        this.weight = weight;
        this.password = password;
        this.isVerified = isVerified;
        this.detailsComplete = detailsComplete;
        this.height=height;
        this.bmi=bmi;
    }



    public double getDailyTarget() {

        double baseTarget = weight * 35;

        if (age > 50) {
            baseTarget -= 200;
        }

        return baseTarget;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}

