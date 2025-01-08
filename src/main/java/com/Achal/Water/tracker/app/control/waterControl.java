package com.Achal.Water.tracker.app.control;


import com.Achal.Water.tracker.app.models.DailyWaterProgress;
import com.Achal.Water.tracker.app.models.FullWaterIntake;
import com.Achal.Water.tracker.app.models.WaterIntakeRequest;
import com.Achal.Water.tracker.app.models.WaterIntakeResponse;
import com.Achal.Water.tracker.app.userServices.WaterService;
import org.hibernate.dialect.lock.OptimisticEntityLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class waterControl {

    @Autowired
     WaterService waterService;


    @PostMapping("/users/{userId}/water/log")
    public ResponseEntity<WaterIntakeResponse> logWaterIntake(
            @PathVariable Integer userId,
      @RequestBody WaterIntakeRequest request) throws Exception {

        Integer amount= request.getWaterConsumed();
        return new ResponseEntity<>(waterService.logWaterIntake(userId,amount), HttpStatus.OK);
       }


    @GetMapping("/users/{userId}/water/progress")
    public ResponseEntity<DailyWaterProgress> getDailyProgress(@PathVariable Integer userId) throws Exception {

            DailyWaterProgress progress = waterService.getDailyProgress(userId);
            return new ResponseEntity<>(progress,HttpStatus.OK);

    }


    @GetMapping("/users/{userId}/water/getTodayRecord")
    public ResponseEntity<Optional<FullWaterIntake>> fullDayRecord(@PathVariable Integer userId){
        return  new ResponseEntity<>(waterService.getFullDayData(userId),HttpStatus.OK);
    }






}
