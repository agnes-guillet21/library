package fr.library.back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class LibraryException extends Exception {

    public LibraryException(String message) {
        super(message);
    }
}


