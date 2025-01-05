package com.Achal.Water.tracker.app.control;


import com.Achal.Water.tracker.app.models.DailyWaterProgress;
import com.Achal.Water.tracker.app.models.WaterIntakeResponse;
import com.Achal.Water.tracker.app.userServices.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class waterControl {

    @Autowired
     WaterService waterService;


    @PostMapping("/{userId}/log")
    public ResponseEntity<WaterIntakeResponse> logWaterIntake(
            @PathVariable Integer userId,
            @RequestParam Double amount) throws Exception {
        return new ResponseEntity<>(waterService.logWaterIntake(userId,amount), HttpStatus.OK);
    }


    @GetMapping("/{userId}/progress")
    public ResponseEntity<DailyWaterProgress> getDailyProgress(@PathVariable Integer userId) throws Exception {

            DailyWaterProgress progress = waterService.getDailyProgress(userId);
            return new ResponseEntity<>(progress,HttpStatus.OK);

    }






}
