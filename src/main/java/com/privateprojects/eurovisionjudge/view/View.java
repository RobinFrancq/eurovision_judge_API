package com.privateprojects.eurovisionjudge.view;

public interface View {
    // MAIN
    interface PublicView{}
    // USER
    interface UserCreateView extends PublicView{}
    interface UserFullView extends UserCreateView{}
}
