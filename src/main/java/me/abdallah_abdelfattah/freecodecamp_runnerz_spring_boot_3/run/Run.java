package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import java.time.LocalDateTime;

public record Run(
    String id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Integer miles,
    Type location
) { }
