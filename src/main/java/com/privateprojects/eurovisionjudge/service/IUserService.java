package com.privateprojects.eurovisionjudge.service;

import com.privateprojects.eurovisionjudge.exception.responseException.EntityAlreadyExistsException;
import com.privateprojects.eurovisionjudge.exception.responseException.EntityNotFoundException;
import com.privateprojects.eurovisionjudge.model.entity.User;

import java.time.LocalDate;
import java.util.Optional;

public interface IUserService {
    Optional<User> findUserByEmail(String email);

    User createUser(String firstName, String lastName, LocalDate dateOfBirth, String email, String password) throws EntityAlreadyExistsException;

    User updateUser(Integer id, String firstName, String lastName, LocalDate dateOfBirth, String email, String password) throws EntityNotFoundException;
}
