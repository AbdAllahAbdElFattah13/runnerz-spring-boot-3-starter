package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        String id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        @NotNull
        Type location
) {

    public Run {
        if (startedOn.isAfter(completedOn)) {
            throw new IllegalArgumentException("Run cannot be completed before it starts," +
                    " startedOn: " + startedOn + ", completedOn: " + completedOn);
        }
    }

    @Nonnull
    public Run withId(String id) {
        return new Run(id, this.title, this.startedOn, this.completedOn, this.miles, this.location);
    }
}
