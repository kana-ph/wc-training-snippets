package com.whitecloak.training.inventory.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;

//@JsonDeserialize
public class ItemForm {


    private String name;
    private Long ownerId;
    private Long categoryId;

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }


    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
