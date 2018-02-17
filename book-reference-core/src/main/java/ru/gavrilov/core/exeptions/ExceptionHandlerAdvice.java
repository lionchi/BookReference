package ru.gavrilov.core.exeptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    Logger log = Logger.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(IllegalOperationException.class)
    public ResponseEntity<?> handle(IllegalOperationException ex) {
        log.error("Exception handling and serialization: " + ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new IllegalOperationExceptionData(ex.getCode(), ex.getMessage()));
    }
}
