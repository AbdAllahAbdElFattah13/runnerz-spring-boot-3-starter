package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import jakarta.validation.Valid;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto.RunDTO;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.service.RunService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/run")
public class RunController {

    private final RunService runService;

    public RunController(RunService runService) {
        this.runService = runService;
    }

    @GetMapping("")
    List<RunDTO> findAll() {
        return runService.listAllRuns();
    }

    @GetMapping("/{id}")
    RunDTO findById(@PathVariable Integer id) {
        return runService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    RunDTO createRun(@Valid @RequestBody RunDTO runDTO) {
        return runService.createRun(runDTO);
    }

    @PutMapping("/{id}")
    RunDTO updateRun(@PathVariable Integer id, @Valid @RequestBody RunDTO runDTO) {
        return runService.updateRun(id, runDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRun(@PathVariable Integer id) {
        runService.deleteRun(id);
    }
}
