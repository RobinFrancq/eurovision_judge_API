package com.privateprojects.eurovisionjudge.model.exception.responseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Wrong credentials were used")
public class WrongCredentialsException extends RuntimeException {
}
