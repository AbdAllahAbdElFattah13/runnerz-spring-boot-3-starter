package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3;

import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.Run;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.RunType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Run run = new Run(1, "First Run", LocalDateTime.now().minusMinutes(30), LocalDateTime.now(), 1, RunType.OUTDOOR, 0);
            System.out.println("A new Run created: " + run);
        };
    }

}
