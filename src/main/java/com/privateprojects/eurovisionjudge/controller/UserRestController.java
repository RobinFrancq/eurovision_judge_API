package com.privateprojects.eurovisionjudge.controller;

import com.privateprojects.eurovisionjudge.converter.IConverter;
import com.privateprojects.eurovisionjudge.dto.UserDTO;
import com.privateprojects.eurovisionjudge.exception.responseException.EntityNotFoundException;
import com.privateprojects.eurovisionjudge.model.User;
import com.privateprojects.eurovisionjudge.service.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/user")
public class UserRestController {

    private final IUserService userService;
    private final IConverter<User, UserDTO> userConverter;

    public UserRestController(@Qualifier("userService") IUserService userService,
                              @Qualifier("userConverter") IConverter<User, UserDTO> userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @GetMapping(value = "/email")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email) {
        User foundUser = userService.findUserByEmail(email).orElseThrow(EntityNotFoundException::new);
        return new ResponseEntity<>(userConverter.toDTO(foundUser), HttpStatus.FOUND);
    }
}
