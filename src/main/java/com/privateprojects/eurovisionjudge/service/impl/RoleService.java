package com.privateprojects.eurovisionjudge.service.impl;

import com.privateprojects.eurovisionjudge.model.entity.Role;
import com.privateprojects.eurovisionjudge.model.enumeration.UserRoleEnum;
import com.privateprojects.eurovisionjudge.repository.RoleRepository;
import com.privateprojects.eurovisionjudge.service.IRoleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("roleService")
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    public RoleService(@Qualifier("roleRepository") RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public Optional<Role> findRoleByName(UserRoleEnum name) {
        return Optional.ofNullable(roleRepository.findByName(name.toString()));
    }
}
