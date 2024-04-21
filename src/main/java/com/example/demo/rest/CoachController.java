package com.example.demo.rest;

import com.example.demo.coach.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {

    /*@Autowired -> Field Injection*/
    private Coach coach;
    private Coach anotherCoach;

    @Autowired
    public CoachController(@Qualifier("swimCoach") Coach coach, @Qualifier("tennisCoach") Coach anotherCoach){
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    /*@Autowired -> Setter Injection
    public void setCoach(Coach coach){
        this.coach = coach;
    }*/
    @GetMapping("/getDailyWorkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

    @GetMapping("/checkScope")
    public String getClassScope(){
        boolean flag = coach == anotherCoach;
        return String.format("Comparing coach & another coach %b", flag);
    }
}
