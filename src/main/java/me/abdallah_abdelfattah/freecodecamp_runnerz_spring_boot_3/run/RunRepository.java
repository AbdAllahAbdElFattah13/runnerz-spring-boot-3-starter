package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run;

import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private final List<Run> runs = new ArrayList<>();

    @PostConstruct
    private void init() {
        runs.add(new Run("1", "First Run", LocalDateTime.now().minusDays(3), LocalDateTime.now().minusDays(3).plusMinutes(30), 1, Type.OUTDOOR));
        runs.add(new Run("2", "Second Run", LocalDateTime.now().minusDays(2), LocalDateTime.now().minusDays(3).plusMinutes(30), 2, Type.INDOOR));
        runs.add(new Run("3", "Third Run", LocalDateTime.now().minusDays(1), LocalDateTime.now().minusDays(1).plusMinutes(30), 3, Type.OUTDOOR));
    }

    List<Run> findAll() {
        return runs;
    }

    Run save(@Nonnull Run run) {
        String id = String.valueOf(runs.size() + 1);
        runs.add(run.withId(id));
        return run.withId(id);
    }

    Optional<Run> findById(@Nonnull String id) {
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void deleteById(@Nonnull String id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    Optional<Run> updateById(@Nonnull String id, @Nonnull Run run) {
        var existingRun = findById(id);

        if (existingRun.isEmpty()) {
            return existingRun;
        }

        runs.set(runs.indexOf(existingRun.get()), run);
        return Optional.of(run);
    }
}
