package com.whitecloak.training.inventory.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;

@JsonDeserialize
public class UserForm {

    private String name;
    private Long categoryId;
    private Long ownerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
