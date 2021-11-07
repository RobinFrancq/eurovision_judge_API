package com.privateprojects.eurovisionjudge.model.exception.responseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not find the entity")
public class EntityNotFoundException extends RuntimeException {
}
