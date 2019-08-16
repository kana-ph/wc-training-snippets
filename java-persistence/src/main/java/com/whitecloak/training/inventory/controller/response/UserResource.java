package com.whitecloak.training.inventory.controller.response;

public class UserResource {

    private long id;
    private String userName;

    public UserResource() {
    }

    public UserResource(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
