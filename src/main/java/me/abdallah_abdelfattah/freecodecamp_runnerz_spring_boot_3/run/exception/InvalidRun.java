package me.abdallah_abdelfattah.freecodecamp_runnerz_spring_boot_3.run.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRun extends RuntimeException {
    public InvalidRun(String message) {
        super(Objects.requireNonNullElse(message, "Invalid run"));
    }
}