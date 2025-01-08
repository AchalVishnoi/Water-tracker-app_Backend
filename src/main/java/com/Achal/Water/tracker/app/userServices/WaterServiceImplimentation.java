package com.Achal.Water.tracker.app.userServices;

import com.Achal.Water.tracker.app.models.*;
import com.Achal.Water.tracker.app.repo.WaterRepo;
import com.Achal.Water.tracker.app.repo.fullWaterIntakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class WaterServiceImplimentation implements WaterService{

    @Autowired
    UserService userService;
    @Autowired
    WaterRepo waterRepo;

    @Autowired
    fullWaterIntakeRepo fullWaterIntakeRepo;

    @Override
    public WaterIntakeResponse logWaterIntake(Integer userId, Integer amount) throws Exception {
        // Retrieve the user
        User user = userService.findUserById(userId);

        // Create and save a new WaterIntake entry
        WaterIntake intake = new WaterIntake();
        intake.setUser(user);
        intake.setWaterConsumed(amount);
        intake.setDate(LocalDate.now());
        intake.setTime(LocalTime.now());
        waterRepo.save(intake);

        double totalConsumed = waterRepo.getDailyTotal(userId, LocalDate.now());
        double target = user.getDailyTarget();

        Optional<FullWaterIntake> optionalFullWaterIntake = fullWaterIntakeRepo.findByDate(LocalDate.now(), userId);

        if (optionalFullWaterIntake.isPresent()) {
            FullWaterIntake fullWaterIntake = optionalFullWaterIntake.get();
            fullWaterIntake.setWaterConsumed(totalConsumed);
            List<WaterIntake> waterIntakes = fullWaterIntake.getWaterIntake();
            waterIntakes.add(intake);
            fullWaterIntake.setWaterIntake(waterIntakes);
            fullWaterIntakeRepo.save(fullWaterIntake);
        } else {
            FullWaterIntake fullWaterIntake = new FullWaterIntake();
            fullWaterIntake.setDate(LocalDate.now());
            fullWaterIntake.setWaterConsumed(totalConsumed);
            List<WaterIntake> waterIntakes = new ArrayList<>();
            waterIntakes.add(intake);
            fullWaterIntake.setWaterIntake(waterIntakes);
            fullWaterIntake.setUser(user);
            fullWaterIntakeRepo.save(fullWaterIntake);
        }





        double progress = (totalConsumed / target) * 100;

        return new WaterIntakeResponse(
                "Water intake logged successfully.",
                target,
                totalConsumed,
                target - totalConsumed,
                progress
        );
    }


    @Override
    public DailyWaterProgress getDailyProgress(Integer userId) throws Exception {
        User user = userService.findUserById(userId);
        double target = user.getDailyTarget();

        LocalDate today = LocalDate.now();
        LocalTime startTime = LocalTime.of(8, 0);  // 8:00 AM
        LocalTime endTime = LocalTime.of(20, 0);   // 8:00 PM

        List<WaterIntake> intakes = waterRepo.getDailyIntakes(userId, today, startTime, endTime);

        double consumed = intakes.stream().mapToDouble(WaterIntake::getWaterConsumed).sum();


        List<WaterTimeline> timeline = intakes.stream()
                .map(i -> new WaterTimeline(i.getTime().toString(), i.getWaterConsumed()))
                .collect(Collectors.toList());

        return new DailyWaterProgress(
                LocalDate.now(),
                target,
                consumed,
                target - consumed,
                (consumed / target) * 100,
                timeline
        );

    }

    @Override
    public double calculateTotalConsumed(Integer userId) {
        return waterRepo.getDailyTotal(userId, LocalDate.now());
    }


    @Override
    public Optional<FullWaterIntake> getFullDayData(Integer userId) {
        return fullWaterIntakeRepo.findByDate(LocalDate.now(), userId);
    }


}



