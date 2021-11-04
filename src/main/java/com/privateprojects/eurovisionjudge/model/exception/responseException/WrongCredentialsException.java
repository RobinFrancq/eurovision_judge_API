package com.privateprojects.eurovisionjudge.model.exception.responseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class WrongCredentialsException extends RuntimeException {
}
