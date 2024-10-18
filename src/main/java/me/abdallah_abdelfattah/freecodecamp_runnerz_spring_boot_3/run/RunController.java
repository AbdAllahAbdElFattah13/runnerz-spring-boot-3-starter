package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    Run findById(@PathVariable String id) {
        var run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found");
        }
        return run.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    Run createRun(@Valid @RequestBody Run run) {
        return runRepository.save(run);
    }

    //put
    @PutMapping("/{id}")
    Run updateRun(@PathVariable String id, @Valid @RequestBody Run run) {
        var updatedRun = runRepository.updateById(id, run);
        if (updatedRun.isEmpty()) {
            throw new RunNotFoundException();
        }
        return updatedRun.get();
    }

    //delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRun(@PathVariable String id) {
        if (!runRepository.deleteById(id)) {
            throw new RunNotFoundException();
        }
    }
}
