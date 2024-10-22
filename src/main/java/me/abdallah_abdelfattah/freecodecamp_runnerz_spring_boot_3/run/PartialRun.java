package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.Optional;

public record PartialRun(
        Optional<String> title,
        Optional<LocalDateTime> startedOn,
        Optional<LocalDateTime> completedOn,
        Optional<Integer> miles,
        Optional<Type> location
) {

    @NonNull
    public Run overrideRunPropertiesIfAny(Integer id, Run run) {
        return new Run(
                id,
                title.orElseGet(run::title),
                startedOn.orElseGet(run::startedOn),
                completedOn.orElseGet(run::completedOn),
                miles.orElseGet(run::miles),
                location.orElseGet(run::location),
                run.version());
    }
}
