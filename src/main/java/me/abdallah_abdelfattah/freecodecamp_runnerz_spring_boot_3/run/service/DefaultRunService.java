package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.service;

import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto.UpdateRunDTO;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.Run;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.exception.RunNotFoundException;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.repository.RunRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultRunService implements RunService {

    RunRepository runRepository;

    public DefaultRunService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @Override
    public List<Run> listAllRuns() {
        return runRepository.findAll();
    }

    @Override
    public Run findById(Integer id) {
        return runRepository.findById(id).orElseThrow(RunNotFoundException::new);
    }

    @Override
    @Transactional
    public Run createRun(Run run) {
        return runRepository.save(run);
    }

    @Override
    @Transactional
    public Run updateRun(Integer id, UpdateRunDTO runDTO) {
        var existingRun = runRepository.findById(id).orElseThrow(RunNotFoundException::new);
        var run = runDTO.toRun(id, existingRun);

        return runRepository.save(run);
    }

    @Override
    @Transactional
    public void deleteRun(Integer id) {
        runRepository.deleteById(id);
    }
}
