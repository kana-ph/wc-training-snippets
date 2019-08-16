package com.whitecloak.training.inventory.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;

@JsonDeserialize
public class UserForm {

    private UserEntity name;

    public UserEntity getName() {
        return name;
    }

    public void setName(UserEntity name) {
        this.name = name;
    }
}
