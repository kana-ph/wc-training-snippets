package com.whitecloak.training.inventory.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class ItemForm {

    private String itemName;
    private Long owner;
    private Long category;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
