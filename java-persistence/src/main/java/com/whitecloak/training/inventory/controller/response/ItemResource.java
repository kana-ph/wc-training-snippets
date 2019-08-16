package com.whitecloak.training.inventory.controller.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.model.User;

@JsonSerialize
public class ItemResource {

    private long id;
    private String name;
    private Category category;
    private User owner;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
