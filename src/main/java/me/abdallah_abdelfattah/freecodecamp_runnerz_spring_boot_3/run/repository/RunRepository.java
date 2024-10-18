package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.repository;

import jakarta.annotation.Nonnull;
import me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.Run;

import java.util.List;
import java.util.Optional;

public interface RunRepository {
    List<Run> findAll();

    Run save(@Nonnull Run run);

    Optional<Run> findById(@Nonnull String id);

    boolean deleteById(@Nonnull String id);

    Optional<Run> updateById(@Nonnull String id, @Nonnull Run run);
}
