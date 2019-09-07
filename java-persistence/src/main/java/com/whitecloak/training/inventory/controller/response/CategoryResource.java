package com.whitecloak.training.inventory.controller.response;

public class CategoryResource {

    private long id;
    private String categoryName;

    public CategoryResource() {
    }

    public CategoryResource(long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
