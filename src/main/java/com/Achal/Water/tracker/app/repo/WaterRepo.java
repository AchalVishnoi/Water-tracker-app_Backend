package com.Achal.Water.tracker.app.repo;

import com.Achal.Water.tracker.app.models.FullWaterIntake;
import com.Achal.Water.tracker.app.models.WaterIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface WaterRepo extends JpaRepository<WaterIntake, Integer> {

    List<WaterIntake> findByUserIdAndDateBetween(Integer userId, LocalDate startDate, LocalDate endDate);
    @Query("SELECT COALESCE(SUM(w.waterConsumed), 0) FROM WaterIntake w WHERE w.user.id = :userId AND w.date = :date")
    double getDailyTotal(@Param("userId") Integer userId, @Param("date") LocalDate date);

//    @Query("SELECT w FROM WaterIntake w WHERE w.user.id = :userId AND w.date >= :startOfDay as date AND w.date < :endOfDay as date")
//    List<WaterIntake> getDailyIntakes(
//            @Param("userId") Integer userId,
//            @Param("startOfDay") LocalDateTime startOfDay,
//            @Param("endOfDay") LocalDateTime endOfDay
//    );

    @Query("SELECT w FROM WaterIntake w WHERE w.user.id = :userId AND w.date = :date AND w.time BETWEEN :startTime AND :endTime")
    List<WaterIntake> getDailyIntakes(
            @Param("userId") Integer userId,
            @Param("date") LocalDate date,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime
    );








}
