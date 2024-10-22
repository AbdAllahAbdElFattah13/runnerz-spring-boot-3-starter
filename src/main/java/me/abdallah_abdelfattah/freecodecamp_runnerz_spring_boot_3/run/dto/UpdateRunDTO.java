package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto;

import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.Run;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.RunType;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.Optional;

public record UpdateRunDTO(
        Optional<String> title,
        Optional<LocalDateTime> startedOn,
        Optional<LocalDateTime> completedOn,
        Optional<Integer> miles,
        Optional<RunType> runType
) {

    @NonNull
    public Run toRun(Integer id, Run run) {
        return new Run(
                id,
                title.orElseGet(run::title),
                startedOn.orElseGet(run::startedOn),
                completedOn.orElseGet(run::completedOn),
                miles.orElseGet(run::miles),
                runType.orElseGet(run::runType),
                run.version());
    }
}
