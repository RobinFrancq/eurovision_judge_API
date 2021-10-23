package com.privateprojects.eurovisionjudge.view;

public interface View {
    // MAIN
    interface PublicView{}
    // USER
    interface UserCreateOrUpdateView extends PublicView{}
    interface UserFullView extends UserCreateOrUpdateView {}
}
