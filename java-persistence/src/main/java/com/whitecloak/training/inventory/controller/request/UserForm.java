package com.whitecloak.training.inventory.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class UserForm {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
