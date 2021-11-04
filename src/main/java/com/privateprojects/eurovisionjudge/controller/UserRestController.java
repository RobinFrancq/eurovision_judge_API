package com.privateprojects.eurovisionjudge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.privateprojects.eurovisionjudge.converter.IConverter;
import com.privateprojects.eurovisionjudge.model.dto.UserDTO;
import com.privateprojects.eurovisionjudge.model.exception.responseException.EntityNotFoundException;
import com.privateprojects.eurovisionjudge.model.entity.User;
import com.privateprojects.eurovisionjudge.service.IUserService;
import com.privateprojects.eurovisionjudge.model.view.View;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController()
@CrossOrigin
public class UserRestController {

    private final IUserService userService;
    private final IConverter<User, UserDTO> userConverter;

    public UserRestController(@Qualifier("userService") IUserService userService,
                              @Qualifier("userConverter") IConverter<User, UserDTO> userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping(value = "/login")
    @JsonView(View.UserFullView.class)
    public ResponseEntity<Boolean> login(@JsonView(View.UserLoginView.class) @RequestBody UserDTO userDTO) {
        User existingUser = userService.findUserByUsername(userDTO.getUsername()).orElseThrow(EntityNotFoundException::new);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return new ResponseEntity<>(passwordEncoder.matches(userDTO.getPassword(), existingUser.getPassword()), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    @JsonView(View.UserFullView.class)
    public ResponseEntity<UserDTO> register(@JsonView(View.UserCreateOrUpdateView.class) @RequestBody UserDTO userDTO) {
        User createdUser = userService.createUser(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getDateOfBirth(),
                userDTO.getEmail(),
                userDTO.getUsername(),
                userDTO.getPassword()
        );
        return new ResponseEntity<>(userConverter.toDTO(createdUser), HttpStatus.CREATED);
    }

    @GetMapping(value = "/user")
    @JsonView(View.UserFullView.class)
    public ResponseEntity<UserDTO> getUserByUsername(@RequestParam(value = "username") String username) {
        User foundUser = userService.findUserByUsername(username).orElseThrow(EntityNotFoundException::new);
        return new ResponseEntity<>(userConverter.toDTO(foundUser), HttpStatus.FOUND);
    }

    @PutMapping("/user/{id}")
    @JsonView(View.UserFullView.class)
    public ResponseEntity<UserDTO> updateUser(@PathParam(value = "id") Integer id,
                                              @JsonView(View.UserCreateOrUpdateView.class) @RequestBody UserDTO userDTO) {
        User updatedUser = userService.updateUser(
                id,
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getDateOfBirth(),
                userDTO.getEmail(),
                userDTO.getUsername(),
                userDTO.getPassword()
        );
        return new ResponseEntity<>(userConverter.toDTO(updatedUser), HttpStatus.ACCEPTED);
    }
}
