package com.example.gapweekapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("dev")
public class GapWeekApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GapWeekApiApplication.class, args);
    }

}
