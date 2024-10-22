package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto.RunDTO;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.Run;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RunMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    Run toRun(RunDTO runDTO);

    RunDTO toRunDTO(Run run);

    default Run updateRun(Run run, RunDTO runDTO) {
        if (runDTO == null) {
            return run;
        }

        return new Run(
                run.id(),
                runDTO.title() != null ? runDTO.title() : run.title(),
                runDTO.startedOn() != null ? runDTO.startedOn() : run.startedOn(),
                runDTO.completedOn() != null ? runDTO.completedOn() : run.completedOn(),
                runDTO.miles() != null ? runDTO.miles() : run.miles(),
                runDTO.runType() != null ? runDTO.runType() : run.runType(),
                run.version()
        );
    }
}
