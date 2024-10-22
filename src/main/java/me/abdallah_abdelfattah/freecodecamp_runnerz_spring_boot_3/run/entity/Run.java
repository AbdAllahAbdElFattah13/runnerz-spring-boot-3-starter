package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.exception.InvalidRun;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(
        @Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        @NotNull
        RunType runType,
        @Version
        Integer version
) {

    public Run {
        if (startedOn.isAfter(completedOn)) {
            throw new InvalidRun(
                    "Run cannot be completed before it starts," +
                            " startedOn: " + startedOn + ", completedOn: " + completedOn
            );
        }
    }

    @Nonnull
    public Run withId(Integer id) {
        return new Run(id, this.title, this.startedOn, this.completedOn, this.miles, this.runType, this.version);
    }
}
