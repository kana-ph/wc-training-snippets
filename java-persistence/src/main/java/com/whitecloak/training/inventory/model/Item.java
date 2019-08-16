package com.whitecloak.training.inventory.model;

public class Item {

    private Long id;
    private String name;
    private Long ownerId;
    private Category category;

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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Category getCategory() { return category;  }

    public void setCategory(Category category) { this.category = category; }
}
