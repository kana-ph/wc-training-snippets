package com.whitecloak.training.inventory.controller.response;

import com.whitecloak.training.inventory.persistence.entity.ItemEntity;

import java.util.Set;

public class CategoryResource {

    private long id;
    private String name;
    private Set<ItemEntity> items;

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

    public Set<ItemEntity> getItems() {
        return items;
    }

    public void setItems(Set<ItemEntity> items) {
        this.items = items;
    }
}
