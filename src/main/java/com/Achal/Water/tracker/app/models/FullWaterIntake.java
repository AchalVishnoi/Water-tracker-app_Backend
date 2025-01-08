package com.Achal.Water.tracker.app.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebProperties.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class FullWaterIntake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   private  LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Relationship with User

    @OneToMany
    private List<WaterIntake> waterIntake;
    private Double waterConsumed;

    public FullWaterIntake(LocalDate date, User user, List<WaterIntake> waterIntake, Double waterConsumed) {
        this.date = date;
        this.user = user;
        this.waterIntake = waterIntake;
        this.waterConsumed = waterConsumed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WaterIntake> getWaterIntake() {
        return waterIntake;
    }

    public void setWaterIntake(List<WaterIntake> waterIntake) {
        this.waterIntake = waterIntake;
    }

    public Double getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(Double waterConsumed) {
        this.waterConsumed = waterConsumed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FullWaterIntake(){}
}
