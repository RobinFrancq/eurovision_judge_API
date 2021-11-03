package com.privateprojects.eurovisionjudge.converter.impl;

import com.privateprojects.eurovisionjudge.converter.IConverter;
import com.privateprojects.eurovisionjudge.model.dto.RoleDTO;
import com.privateprojects.eurovisionjudge.model.dto.UserDTO;
import com.privateprojects.eurovisionjudge.model.entity.Role;
import com.privateprojects.eurovisionjudge.model.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter extends AbstractConverter<User, UserDTO>  {

    private final IConverter<Role, RoleDTO> roleConverter;

    public UserConverter(@Qualifier("roleConverter") IConverter<Role, RoleDTO> roleConverter) {
        this.roleConverter = roleConverter;
    }

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
            userDTO.setUsername(user.getUsername());
            userDTO.setPassword(user.getPassword());
            userDTO.setRoles(roleConverter.toDTOCollection(user.getRoles()));
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
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user.setRoles(roleConverter.fromDTOCollection(userDTO.getRoles()));
        }
        return user;
    }
}
