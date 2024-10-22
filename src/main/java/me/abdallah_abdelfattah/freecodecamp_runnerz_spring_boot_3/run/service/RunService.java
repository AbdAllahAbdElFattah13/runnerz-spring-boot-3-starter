package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.service;

import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto.RunDTO;

import java.util.List;

public interface RunService {
    List<RunDTO> listAllRuns();

    RunDTO findById(Integer id);

    RunDTO createRun(RunDTO runDTO);

    RunDTO updateRun(Integer id, RunDTO runDTO);

    void deleteRun(Integer id);
}
