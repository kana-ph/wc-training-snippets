package com.whitecloak.training.inventory.controller.response;

import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;

public class ItemResource {

    private long id;
    private String itemName;
    private UserEntity owner;
    private CategoryEntity category;

    public ItemResource() {
    }

    public ItemResource(long id, String itemName, UserEntity owner, CategoryEntity category) {
        this.id = id;
        this.itemName = itemName;
        this.owner = owner;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
