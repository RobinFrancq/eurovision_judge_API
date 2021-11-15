package com.privateprojects.eurovisionjudge.service;

import com.privateprojects.eurovisionjudge.model.exception.responseException.UserAlreadyExistsException;
import com.privateprojects.eurovisionjudge.model.exception.responseException.UserNotFoundException;
import com.privateprojects.eurovisionjudge.model.entity.User;

import java.time.LocalDate;
import java.util.Optional;

public interface IUserService {
    Optional<User> findUserByUsername(String username);

    User createUser(String firstName, String lastName, LocalDate dateOfBirth, String email,
                    String username, String password) throws UserAlreadyExistsException;

    User updateUser(Integer id, String firstName, String lastName, LocalDate dateOfBirth, String email,
                    String username, String password) throws UserNotFoundException;
}
