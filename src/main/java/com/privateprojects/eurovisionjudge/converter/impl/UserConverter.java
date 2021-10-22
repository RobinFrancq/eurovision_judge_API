package com.privateprojects.eurovisionjudge.converter.impl;

import com.privateprojects.eurovisionjudge.dto.UserDTO;
import com.privateprojects.eurovisionjudge.model.User;
import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter extends AbstractConverter<User, UserDTO>  {
    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = null;
        if (user != null) {
            userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setDateOfBirth(user.getDateOfBirth());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            userDTO.setCreatedAt(user.getCreatedAt());
        }
        return userDTO;
    }
    @Override
    public User fromDTO(UserDTO userDTO) {
        User user = null;
        if (userDTO != null) {
            user = new User();
            user.setId(userDTO.getId());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setDateOfBirth(userDTO.getDateOfBirth());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setCreatedAt(userDTO.getCreatedAt());
        }
        return user;
    }
}
