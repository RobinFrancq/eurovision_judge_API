package com.privateprojects.eurovisionjudge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.privateprojects.eurovisionjudge.converter.IConverter;
import com.privateprojects.eurovisionjudge.dto.UserDTO;
import com.privateprojects.eurovisionjudge.exception.responseException.EntityNotFoundException;
import com.privateprojects.eurovisionjudge.model.User;
import com.privateprojects.eurovisionjudge.service.IUserService;
import com.privateprojects.eurovisionjudge.view.View;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController()
@RequestMapping(value = "/user")
public class UserRestController {

    private final IUserService userService;
    private final IConverter<User, UserDTO> userConverter;

    public UserRestController(@Qualifier("userService") IUserService userService,
                              @Qualifier("userConverter") IConverter<User, UserDTO> userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @GetMapping()
    @JsonView(View.UserFullView.class)
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email) {
        User foundUser = userService.findUserByEmail(email).orElseThrow(EntityNotFoundException::new);
        return new ResponseEntity<>(userConverter.toDTO(foundUser), HttpStatus.FOUND);
    }

    @PostMapping()
    @JsonView(View.UserFullView.class)
    public ResponseEntity<UserDTO> createUser(@JsonView(View.UserCreateOrUpdateView.class) @RequestBody UserDTO userDTO) {
        User createdUser = userService.createUser(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getDateOfBirth(),
                userDTO.getEmail(),
                userDTO.getPassword()
        );
        return new ResponseEntity<>(userConverter.toDTO(createdUser), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @JsonView(View.UserFullView.class)
    public ResponseEntity<UserDTO> updateUser(@PathParam(value = "id") Integer id,
                                              @JsonView(View.UserCreateOrUpdateView.class) @RequestBody UserDTO userDTO) {
        User updatedUser = userService.updateUser(
                id,
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getDateOfBirth(),
                userDTO.getEmail(),
                userDTO.getPassword()
        );
        return new ResponseEntity<>(userConverter.toDTO(updatedUser), HttpStatus.ACCEPTED);
    }
}
