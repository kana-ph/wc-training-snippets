package com.whitecloak.training.inventory.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.whitecloak.training.inventory.model.Item;

import java.util.Set;

@JsonDeserialize
public class CategoryForm {

    private String categoryName;
//    private Set<Item> items;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

//    public Set<Item> getItems() {
//        return items;
//    }

//    public void setItems(Set<Item> items) {
//        this.items = items;
//    }
}
