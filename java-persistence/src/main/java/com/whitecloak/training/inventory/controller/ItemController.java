package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/api/v1/items")
    public ItemResource createItem(@RequestBody ItemForm form) {
        return itemService.create(form);
    }

    @GetMapping("/api/v1/items/{id}")
    public ItemEntity getItem(@PathVariable("id") Long id) {
        return itemService.getItem(id);

        }

    }


