package com.example.demo.coach;

import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice BasketBall for 1Hr!";
    }
}
