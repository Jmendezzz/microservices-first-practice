package org.mendez.springcloud.msvc.users.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException exc){

      Map<String, String> errors = new HashMap<>();
      exc.getConstraintViolations().forEach(violation -> {
        String fieldName =  String.valueOf(violation.getPropertyPath());
        errors.put( fieldName, "El campo " + fieldName + " " + violation.getMessage());
      });
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

  @ExceptionHandler(CustomHttpException.class)
  public ResponseEntity<?> handleCustomHttpExceptions(CustomHttpException exc){
    return new ResponseEntity<>(Collections.singletonMap("message",exc.message), exc.httpStatus);
  }
}
