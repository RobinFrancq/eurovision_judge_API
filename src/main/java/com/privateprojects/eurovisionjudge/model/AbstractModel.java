package com.privateprojects.eurovisionjudge.model;

import javax.persistence.*;

@Entity
public abstract class AbstractModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    public AbstractModel() {}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
}
