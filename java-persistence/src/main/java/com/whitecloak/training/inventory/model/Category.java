package com.whitecloak.training.inventory.model;

public class Category {

    private Long id;
    private String item;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String  getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
