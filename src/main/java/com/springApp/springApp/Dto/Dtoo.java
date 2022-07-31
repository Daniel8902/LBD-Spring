package com.springApp.springApp.Dto;

import lombok.Data;


public class Dtoo {
    private long id  ;
    private String name;

  public Dtoo(){}
    public Dtoo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dtoo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
