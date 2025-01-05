package com.Achal.Water.tracker.app.models;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class WaterIntake {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Relationship with User

    private LocalDateTime date;
    private Double waterConsumed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(Double waterConsumed) {
        this.waterConsumed = waterConsumed;
    }

    public WaterIntake(Integer id, User user, LocalDateTime date, Double waterConsumed) {
        this.id = id;
        this.user=user;
        this.date = date;
        this.waterConsumed = waterConsumed;
    }

    public WaterIntake() {}
}
