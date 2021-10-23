package com.privateprojects.eurovisionjudge.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.privateprojects.eurovisionjudge.view.View;

import java.io.Serializable;

public abstract class AbstractDTO implements Serializable {
    @JsonView(View.PublicView.class)
    private Integer id;

    public AbstractDTO() {}
    public AbstractDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
}
