package com.Achal.Water.tracker.app.control;


import com.Achal.Water.tracker.app.models.DailyWaterProgress;
import com.Achal.Water.tracker.app.models.FullWaterIntake;
import com.Achal.Water.tracker.app.models.WaterIntakeRequest;
import com.Achal.Water.tracker.app.response.WaterIntakeResponse;
import com.Achal.Water.tracker.app.userServices.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
public class waterControl {

    @Autowired
     WaterService waterService;
    @Autowired
    UserController userController;


    @PostMapping("/api/users/water/log")
    public ResponseEntity<WaterIntakeResponse> logWaterIntake(
            @RequestHeader("Authorization") String jwt,@RequestBody WaterIntakeRequest request) throws Exception {

        Integer userId= Math.toIntExact(userController.getUserByJwt(jwt).getId());

        Integer amount= request.getWaterConsumed();
        return new ResponseEntity<>(waterService.logWaterIntake(userId,amount), HttpStatus.OK);
       }


    @GetMapping("/api/users/water/progress")
    public ResponseEntity<DailyWaterProgress> getDailyProgress(@RequestHeader("Authorization") String jwt) throws Exception {

        Integer userId= Math.toIntExact(userController.getUserByJwt(jwt).getId());

        DailyWaterProgress progress = waterService.getDailyProgress(userId);
            return new ResponseEntity<>(progress,HttpStatus.OK);

    }


    @GetMapping("/api/users/water/getTodayRecord")
    public ResponseEntity<Optional<FullWaterIntake>> fullDayRecord(@RequestHeader("Authorization") String jwt) throws Exception {

        Integer userId= Math.toIntExact(userController.getUserByJwt(jwt).getId());

        return  new ResponseEntity<>(waterService.getFullDayData(userId),HttpStatus.OK);
    }






}
