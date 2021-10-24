package com.privateprojects.eurovisionjudge.service.impl;

import com.privateprojects.eurovisionjudge.enumeration.UserRoleEnum;
import com.privateprojects.eurovisionjudge.exception.responseException.EntityAlreadyExistsException;
import com.privateprojects.eurovisionjudge.exception.responseException.EntityNotFoundException;
import com.privateprojects.eurovisionjudge.model.entity.User;
import com.privateprojects.eurovisionjudge.model.security.EurovisionJudgeUserDetails;
import com.privateprojects.eurovisionjudge.repository.UserRepository;
import com.privateprojects.eurovisionjudge.service.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service("userService")
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(@Qualifier("userRepository") UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
    @Override
    public User createUser(String firstName, String lastName, LocalDate dateOfBirth, String email, String password) throws EntityAlreadyExistsException {
        Optional<User> existingUserOptional = findUserByEmail(email);
        if (existingUserOptional.isEmpty()) {
            User newUser = new User();
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setDateOfBirth(dateOfBirth);
            newUser.setEmail(email);
            newUser.setPassword(this.passwordEncoder.encode(password));
            newUser.setUserRole(UserRoleEnum.USER);
            return userRepository.save(newUser);
        } else {
            throw new EntityAlreadyExistsException();
        }
    }
    @Override
    public User updateUser(Integer id, String firstName, String lastName, LocalDate dateOfBirth, String email, String password) throws EntityNotFoundException {
        User userToUpdate = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        userToUpdate.setFirstName(firstName);
        userToUpdate.setLastName(lastName);
        userToUpdate.setDateOfBirth(dateOfBirth);
        userToUpdate.setEmail(email);
        userToUpdate.setPassword(password);
        return userRepository.save(userToUpdate);
    }
}
