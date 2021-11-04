package com.privateprojects.eurovisionjudge.model.entity;

import com.privateprojects.eurovisionjudge.model.enumeration.UserRoleEnum;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "ROLE")
@Entity
public class Role extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME", nullable = false, length = 20)
    private UserRoleEnum name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public UserRoleEnum getName() {
        return name;
    }

    public void setName(UserRoleEnum name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}