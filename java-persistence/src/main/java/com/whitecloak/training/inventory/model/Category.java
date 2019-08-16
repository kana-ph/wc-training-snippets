package com.whitecloak.training.inventory.model;

import com.whitecloak.training.inventory.persistence.entity.ItemEntity;

import java.util.Set;

public class Category {
    private Long id;
    private String name;
    private Set<ItemEntity> items;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

//    public Set<ItemEntity> getItems() { return items; }
//    public void setItems(Set<ItemEntity> items) { this.items = items; }
}
