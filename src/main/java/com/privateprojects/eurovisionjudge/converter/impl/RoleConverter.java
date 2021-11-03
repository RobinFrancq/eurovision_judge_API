package com.privateprojects.eurovisionjudge.converter.impl;

import com.privateprojects.eurovisionjudge.model.dto.RoleDTO;
import com.privateprojects.eurovisionjudge.model.entity.Role;
import org.springframework.stereotype.Component;

@Component("roleConverter")
public class RoleConverter extends AbstractConverter<Role, RoleDTO> {
    @Override
    public RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = null;
        if (role != null) {
            roleDTO = new RoleDTO();
            roleDTO.setId(role.getId());
            roleDTO.setName(role.getName());
        }
        return roleDTO;
    }
    @Override
    public Role fromDTO(RoleDTO roleDTO) {
        Role role = null;
        if (roleDTO != null) {
            role = new Role();
            role.setId(roleDTO.getId());
            role.setName(roleDTO.getName());
        }
        return role;
    }
}
