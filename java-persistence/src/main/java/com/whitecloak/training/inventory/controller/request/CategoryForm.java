package com.whitecloak.training.inventory.controller.request;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class CategoryForm {

    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
