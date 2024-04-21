package com.example.demo.coach;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This can be used when there a third party class where we can't annotate @Component
@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){//bean id default to method Name
        return new SwimCoach();
    }
}
