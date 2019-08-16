package com.whitecloak.training.inventory.controller.response;

public class CategoryResource {

    private long id;
    private String name;
    private String item;

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

    public String getItem() {
        return item;
    }

    public void setItem(String item) { this.item = item; }

    }

