package com.Achal.Water.tracker.app.models;

import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class WaterIntake {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // Relationship with User

    private LocalDate date;
    private LocalTime time;
    private Integer waterConsumed;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getWaterConsumed() {
        return waterConsumed;
    }

    public void setWaterConsumed(Integer waterConsumed) {
        this.waterConsumed = waterConsumed;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public WaterIntake(Integer id, User user, LocalDate date, LocalTime time, Integer waterConsumed) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.time = time;
        this.waterConsumed = waterConsumed;
    }

    public WaterIntake() {}
}
