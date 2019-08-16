package com.whitecloak.training.inventory.model;

import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;

public class Item {

    private Long id;
    private String name;
    private UserEntity owner;
    private CategoryEntity category;
    private String status;

    public UserEntity getOwner() { return owner; }
    public void setOwner(UserEntity owner) { this.owner = owner; }

    public CategoryEntity getCategory() { return category; }
    public void setCategory(CategoryEntity category) { this.category = category; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
