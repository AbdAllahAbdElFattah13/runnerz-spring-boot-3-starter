package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.service;

import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.RunMapper;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto.RunDTO;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.exception.RunNotFoundException;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.repository.RunRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultRunService implements RunService {

    RunRepository runRepository;
    RunMapper runMapper;

    public DefaultRunService(RunRepository runRepository, RunMapper runMapper) {
        this.runRepository = runRepository;
        this.runMapper = runMapper;
    }

    @Override
    public List<RunDTO> listAllRuns() {
        return runMapper.toRunDTOs(runRepository.findAll());
    }

    @Override
    public RunDTO findById(Integer id) {
        var run = runRepository.findById(id).orElseThrow(RunNotFoundException::new);
        return runMapper.toRunDTO(run);
    }

    @Override
    @Transactional
    public RunDTO createRun(RunDTO runDTO) {
        return runMapper.toRunDTO(runRepository.save(runMapper.toRun(runDTO)));
    }

    @Override
    @Transactional
    public RunDTO updateRun(Integer id, RunDTO runDTO) {
        var existingRun = runRepository.findById(id).orElseThrow(RunNotFoundException::new);
        var run = runMapper.updateRun(existingRun, runDTO);
        var updatedRun = runRepository.save(run);

        return runMapper.toRunDTO(updatedRun);
    }

    @Override
    @Transactional
    public void deleteRun(Integer id) {
        runRepository.deleteById(id);
    }
}
