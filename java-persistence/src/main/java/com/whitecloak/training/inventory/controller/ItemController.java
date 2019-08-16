package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/api/v1/items")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResource createItem(@RequestBody ItemForm itemForm, UserForm userForm, CategoryForm categoryForm) {
        return itemService.create(itemForm, userForm, categoryForm);
    }

//    @GetMapping("/api/v1/items/{id}")
}
