package com.whitecloak.training.inventory.controller.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;

import java.util.Set;

@JsonDeserialize
public class CategoryForm {

    private CategoryEntity name;

    public CategoryEntity getName() {
        return name;
    }

    public void setName(CategoryEntity name) {
        this.name = name;
    }
}
