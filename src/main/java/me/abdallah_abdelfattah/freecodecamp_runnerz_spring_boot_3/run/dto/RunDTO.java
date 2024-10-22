package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto;

import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.RunType;

import java.time.LocalDateTime;

public record RunDTO(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        RunType runType
) {
}
