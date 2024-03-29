package com.privateprojects.eurovisionjudge.model.exception.responseException;

import com.privateprojects.eurovisionjudge.util.EuropeanJudgeConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = EuropeanJudgeConstants.WRONG_CREDENTIALS_EXCEPTION)
public class WrongCredentialsException extends RuntimeException {
}
