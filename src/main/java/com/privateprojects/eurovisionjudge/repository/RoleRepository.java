package com.privateprojects.eurovisionjudge.repository;

import com.privateprojects.eurovisionjudge.model.entity.Role;
import com.privateprojects.eurovisionjudge.model.entity.User;
import com.privateprojects.eurovisionjudge.model.enumeration.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT r FROM Role r WHERE r.name = :name")
    Role findByName(@Param("name") UserRoleEnum name);
}
