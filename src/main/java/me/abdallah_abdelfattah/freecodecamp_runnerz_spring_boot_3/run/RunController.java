package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import jakarta.validation.Valid;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.dto.UpdateRunDTO;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.Run;
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
    List<Run> findAll() {
        return runService.listAllRuns();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        return runService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    Run createRun(@Valid @RequestBody Run run) {
        return runService.createRun(run);
    }

    @PutMapping("/{id}")
    Run updateRun(@PathVariable Integer id, @Valid @RequestBody UpdateRunDTO updateRunDTO) {
        return runService.updateRun(id, updateRunDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRun(@PathVariable Integer id) {
        runService.deleteRun(id);
    }
}
