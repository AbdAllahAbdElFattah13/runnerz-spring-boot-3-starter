package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.service;

import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto.UpdateRunDTO;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.Run;

import java.util.List;

public interface RunService {
    List<Run> listAllRuns();

    Run findById(Integer id);

    Run createRun(Run run);

    Run updateRun(Integer id, UpdateRunDTO partialRun);

    void deleteRun(Integer id);
}
