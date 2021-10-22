package com.privateprojects.eurovisionjudge.dto;

import java.io.Serializable;

public abstract class AbstractDTO implements Serializable {
    private Integer id;

    public AbstractDTO() {}
    public AbstractDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
}
