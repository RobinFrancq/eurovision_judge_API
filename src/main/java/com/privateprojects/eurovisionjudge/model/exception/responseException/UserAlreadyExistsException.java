package com.privateprojects.eurovisionjudge.model.exception.responseException;

import com.privateprojects.eurovisionjudge.util.EuropeanJudgeConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = EuropeanJudgeConstants.USER_ALREADY_EXISTS_EXCEPTION)
public class UserAlreadyExistsException extends RuntimeException {
}
