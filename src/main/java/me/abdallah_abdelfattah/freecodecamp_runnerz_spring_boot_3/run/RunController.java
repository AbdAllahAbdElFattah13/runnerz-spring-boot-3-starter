package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import jakarta.validation.Valid;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto.UpdateRunDTO;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.Run;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.exception.RunNotFoundException;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.repository.RunRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/run")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        var run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    Run createRun(@Valid @RequestBody Run run) {
        return runRepository.save(run);
    }

    @PutMapping("/{id}")
    Run updateRun(@PathVariable Integer id, @Valid @RequestBody UpdateRunDTO partialRun) {
        var existingRun = runRepository.findById(id)
                .orElseThrow(RunNotFoundException::new);
        var run = partialRun.toRun(id, existingRun);

        return runRepository.save(run);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRun(@PathVariable Integer id) {
        if (runRepository.findById(id).isEmpty()) {
            throw new RunNotFoundException();
        }

        runRepository.deleteById(id);
    }
}
