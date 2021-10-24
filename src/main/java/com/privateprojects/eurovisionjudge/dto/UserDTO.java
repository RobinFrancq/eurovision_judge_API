package com.privateprojects.eurovisionjudge.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.privateprojects.eurovisionjudge.view.View;

import java.time.Instant;
import java.time.LocalDate;

public class UserDTO extends AbstractDTO {
    @JsonView(View.UserCreateOrUpdateView.class)
    private String firstName;
    @JsonView(View.UserCreateOrUpdateView.class)
    private String lastName;
    @JsonView(View.UserCreateOrUpdateView.class)
    private LocalDate dateOfBirth;
    @JsonView({View.UserLoginView.class, View.UserCreateOrUpdateView.class})
    private String email;
    @JsonView({View.UserLoginView.class, View.UserCreateOrUpdateView.class})
    private String password;
    @JsonView(View.UserFullView.class)
    private Instant createdAt;

    public UserDTO() {
        super();
    }
    public UserDTO(Integer id, String firstName, String lastName, LocalDate dateOfBirth, String email,
                   String password, Instant createdAt) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public Instant getCreatedAt() {return createdAt;}
    public void setCreatedAt(Instant createdAt) {this.createdAt = createdAt;}
}
