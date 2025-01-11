package com.Achal.Water.tracker.app.userServices;

import com.Achal.Water.tracker.app.models.DailyWaterProgress;
import com.Achal.Water.tracker.app.models.FullWaterIntake;
import com.Achal.Water.tracker.app.response.WaterIntakeResponse;

import java.util.Optional;


public interface WaterService  {
      public WaterIntakeResponse logWaterIntake(Integer userId, Integer amount) throws Exception;

     public DailyWaterProgress getDailyProgress(Integer userId) throws Exception;


    public double calculateTotalConsumed(Integer userId);


    Optional<FullWaterIntake> getFullDayData(Integer userId);
}
