package org.mendez.springcloud.msvc.users.exceptions;

import org.springframework.http.HttpStatus;

public class UserDuplicatedEmailException extends CustomHttpException{
  public UserDuplicatedEmailException() {
    super("There's already an user with that email.", HttpStatus.BAD_REQUEST);
  }
}
