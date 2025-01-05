package com.Achal.Water.tracker.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
public class WaterIntake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private LocalDate date;
    private int waterConsumed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(int waterConsumed) {
        this.waterConsumed = waterConsumed;
    }

    public WaterIntake(Integer id, Integer userId, LocalDate date, int waterConsumed) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.waterConsumed = waterConsumed;
    }

    public WaterIntake() {}
}
