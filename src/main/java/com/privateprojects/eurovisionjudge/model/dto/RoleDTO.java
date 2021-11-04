package com.privateprojects.eurovisionjudge.model.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.privateprojects.eurovisionjudge.model.enumeration.UserRoleEnum;
import com.privateprojects.eurovisionjudge.model.view.View;

public class RoleDTO extends AbstractDTO {
    @JsonView(View.RoleFullView.class)
    private UserRoleEnum name;

    public RoleDTO() {
        super();
    }
    public RoleDTO(Integer id, UserRoleEnum name) {
        super(id);
        this.name = name;
    }

    public UserRoleEnum getName() {
        return name;
    }
    public void setName(UserRoleEnum name) {
        this.name = name;
    }
}
