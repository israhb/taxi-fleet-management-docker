package com.mentedigital.israel.taxis.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice // Esta anotación es la clave
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundExeption.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundExeption ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage()); // Aquí aparecerá "Credenciales incorrectas"

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}