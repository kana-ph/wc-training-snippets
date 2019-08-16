package com.whitecloak.training.inventory.model;

import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;

public class Item {

    private Long id;
    private String name;
    private UserEntity ownerId;
    private CategoryEntity categoryId;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UserEntity ownerId) {
        this.ownerId = ownerId;
    }

    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
