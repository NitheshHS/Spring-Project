package com.example.demo.coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) -> Used chnage the bean scope by default it's a singleton design
public class TennisCoach implements Coach {

    //define post init
    @PostConstruct
    public void doPostStuff() {
        System.out.println("Inside post construct : " + getClass().getSimpleName());
    }

    //define destroy method
    @PreDestroy
    public void preDestroy() {
        System.out.println("Inside pre destroy : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Tennis for 30 MIN!";
    }
}
