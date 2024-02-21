package org.mendez.springcloud.msvc.users.exceptions;

import org.springframework.http.HttpStatus;

public class CustomHttpException extends RuntimeException{
  public  String message;
  public  HttpStatus httpStatus;

  public CustomHttpException(String message, HttpStatus httpStatus) {
    this.message = message;
    this.httpStatus = httpStatus;
  }
}
