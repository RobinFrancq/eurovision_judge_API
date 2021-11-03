package com.privateprojects.eurovisionjudge.model.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.privateprojects.eurovisionjudge.view.View;

import java.time.LocalDate;
import java.util.List;

public class UserDTO extends AbstractDTO {
    @JsonView(View.UserCreateOrUpdateView.class)
    private String firstName;
    @JsonView(View.UserCreateOrUpdateView.class)
    private String lastName;
    @JsonView(View.UserCreateOrUpdateView.class)
    private LocalDate dateOfBirth;
    @JsonView({View.UserCreateOrUpdateView.class})
    private String email;
    @JsonView({View.UserLoginView.class, View.UserCreateOrUpdateView.class})
    private String username;
    @JsonView({View.UserLoginView.class, View.UserCreateOrUpdateView.class})
    private String password;
    @JsonView({View.UserFullView.class})
    private List<RoleDTO> roles;

    public UserDTO() {
        super();
    }
    public UserDTO(Integer id, String firstName, String lastName, LocalDate dateOfBirth, String email,
                   String username, String password, List<RoleDTO> roles) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }
    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}
