package com.privateprojects.eurovisionjudge.repository;

import com.privateprojects.eurovisionjudge.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends AbstractRepository<User> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

}