package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import jakarta.annotation.Nonnull;

import java.time.LocalDateTime;

public record Run(
        String id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Type location
) {

    @Nonnull
    public Run withId(String id) {
        return new Run(id, this.title, this.startedOn, this.completedOn, this.miles, this.location);
    }
}
