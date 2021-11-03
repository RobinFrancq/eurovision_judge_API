package com.privateprojects.eurovisionjudge.service;

import com.privateprojects.eurovisionjudge.model.entity.Role;
import com.privateprojects.eurovisionjudge.model.enumeration.UserRoleEnum;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findRoleById(Integer id);

    Optional<Role> findRoleByName(UserRoleEnum name);
}
