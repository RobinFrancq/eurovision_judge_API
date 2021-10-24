package com.privateprojects.eurovisionjudge.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.privateprojects.eurovisionjudge.dto.UserDTO;
import com.privateprojects.eurovisionjudge.service.IUserService;
import com.privateprojects.eurovisionjudge.view.View;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SessionController {

    private final IUserService userService;

    public SessionController(@Qualifier("userService") IUserService userService) {
        this.userService = userService;
    }

}
