package com.privateprojects.eurovisionjudge.model.view;

public interface View {
    // MAIN
    interface PublicView{}
    // USER
    interface UserLoginView extends PublicView{}
    interface UserCreateOrUpdateView extends UserLoginView{}
    interface UserFullView extends UserCreateOrUpdateView {}
    // ROLE
    interface RoleFullView extends PublicView{}
}
