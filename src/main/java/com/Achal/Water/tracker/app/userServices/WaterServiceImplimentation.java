package com.Achal.Water.tracker.app.userServices;

import com.Achal.Water.tracker.app.models.*;
import com.Achal.Water.tracker.app.repo.WaterRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class WaterServiceImplimentation implements WaterService{

    @Autowired
    UserService userService;
    @Autowired
    WaterRepo waterRepo;

    @Override
    public WaterIntakeResponse logWaterIntake(Integer userId, Double amount) throws Exception {
        User user = userService.findUserById(userId);
        WaterIntake intake = new WaterIntake();
        intake.setUser(user);
        intake.setWaterConsumed(amount);
        intake.setDate(LocalDateTime.now());

        waterRepo.save(intake);

        double totalConsumed = waterRepo.getDailyTotal(userId, LocalDate.now());
        double target = user.getDailyTarget();

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
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);

        List<WaterIntake> intakes = waterRepo.getDailyIntakes(userId, startOfDay, endOfDay);
        double consumed = intakes.stream().mapToDouble(WaterIntake::getWaterConsumed).sum();

        List<WaterTimeline> timeline = intakes.stream()
                .map(i -> new WaterTimeline(i.getDate().toLocalTime().toString(), i.getWaterConsumed()))
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


}



