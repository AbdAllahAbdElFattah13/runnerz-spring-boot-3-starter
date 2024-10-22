package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.repository;

import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.entity.Run;
import org.springframework.data.repository.ListCrudRepository;

public interface RunRepository extends ListCrudRepository<Run, Integer> {
}
