package com.whitecloak.training.inventory.model;

import java.util.List;
import java.util.Set;

public class Category {

    private Long id;
    private String name;
    //private Set<Item> items;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    //public Set<Item> getItems() { return items; }

    //public void setItems(Set<Item> items) { this.items = items; }
}
