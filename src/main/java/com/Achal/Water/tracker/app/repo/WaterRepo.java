package com.Achal.Water.tracker.app.repo;

import com.Achal.Water.tracker.app.models.WaterIntake;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface WaterRepo extends JpaRepository<WaterIntake, Integer> {

    List<WaterIntake> findByUserIdAndDateBetween(Integer userId, LocalDate startDate, LocalDate endDate);


}
