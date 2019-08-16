package com.whitecloak.training.inventory.controller.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class UserResource {

    private long id;
    private String name;

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

}
