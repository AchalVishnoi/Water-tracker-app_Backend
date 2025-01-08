package com.Achal.Water.tracker.app.repo;

import com.Achal.Water.tracker.app.models.FullWaterIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface fullWaterIntakeRepo extends JpaRepository<FullWaterIntake, Integer> {


    @Query("SELECT f FROM FullWaterIntake f WHERE f.date = :date AND f.user.id = :userId")
    Optional<FullWaterIntake> findByDate(@Param("date") LocalDate date, @Param("userId") Integer userId);

}
