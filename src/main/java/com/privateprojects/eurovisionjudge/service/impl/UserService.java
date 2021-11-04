package com.privateprojects.eurovisionjudge.service.impl;

import com.privateprojects.eurovisionjudge.model.entity.Role;
import com.privateprojects.eurovisionjudge.model.enumeration.UserRoleEnum;
import com.privateprojects.eurovisionjudge.model.exception.responseException.EntityAlreadyExistsException;
import com.privateprojects.eurovisionjudge.model.exception.responseException.EntityNotFoundException;
import com.privateprojects.eurovisionjudge.model.entity.User;
import com.privateprojects.eurovisionjudge.repository.UserRepository;
import com.privateprojects.eurovisionjudge.service.IRoleService;
import com.privateprojects.eurovisionjudge.service.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service("userService")
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;

    public UserService(@Qualifier("userRepository") UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       @Qualifier("roleService") IRoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
    @Override
    public User createUser(String firstName, String lastName, LocalDate dateOfBirth, String email,
                           String username, String password) throws EntityAlreadyExistsException {
        Optional<User> existingUserOptional = findUserByUsername(username);
        if (existingUserOptional.isEmpty()) {
            User newUser = new User();
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setDateOfBirth(dateOfBirth);
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setPassword(this.passwordEncoder.encode(password));
            newUser.setRoles(Set.of(getDefaultRole()));
            return userRepository.save(newUser);
        } else {
            throw new EntityAlreadyExistsException();
        }
    }
    @Override
    public User updateUser(Integer id, String firstName, String lastName, LocalDate dateOfBirth, String email,
                           String username, String password) throws EntityNotFoundException {
        User userToUpdate = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        userToUpdate.setFirstName(firstName);
        userToUpdate.setLastName(lastName);
        userToUpdate.setDateOfBirth(dateOfBirth);
        userToUpdate.setEmail(email);
        userToUpdate.setUsername(username);
        userToUpdate.setPassword(password);
        return userRepository.save(userToUpdate);
    }

    private Role getDefaultRole() {
        return roleService.findRoleByName(UserRoleEnum.USER).orElseThrow(EntityNotFoundException::new);
    }
}
