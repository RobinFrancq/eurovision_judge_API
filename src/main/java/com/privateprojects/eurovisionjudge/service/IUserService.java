package com.privateprojects.eurovisionjudge.service;

import com.privateprojects.eurovisionjudge.model.User;

import java.time.LocalDate;
import java.util.Optional;

public interface IUserService {

    Optional<User> findUserByEmail(String email);

    User createUser(String firstName, String lastName, LocalDate dateOfBirth, String email, String password);

}
