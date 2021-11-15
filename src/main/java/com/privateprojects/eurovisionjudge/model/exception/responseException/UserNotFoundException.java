package com.privateprojects.eurovisionjudge.model.exception.responseException;

import com.privateprojects.eurovisionjudge.util.EuropeanJudgeConstants;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = EuropeanJudgeConstants.USER_NOT_FOUND_EXCEPTION)
public class UserNotFoundException extends RuntimeException {
}
