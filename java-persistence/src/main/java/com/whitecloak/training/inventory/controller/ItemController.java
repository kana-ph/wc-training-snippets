package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.controller.response.PaginateResource;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemResource createItem(@RequestBody ItemForm form) {
        return itemService.create(form);
    }

    @ResponseStatus()
    @GetMapping("/{id}")
    public ItemResource getItem(@PathVariable("id") Long id){
        try {
            return itemService.getItem(id);
        }catch (NullPointerException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found", ex);
        }

    }

    @GetMapping
    public Page<ItemResource> getItems(@RequestParam(name = "category", required = false) String category, Pageable pageable){
        if(category == null){
            return itemService.getItems(pageable);
        }
        else{
            return itemService.getItems(category, pageable);
        }
    }

    @DeleteMapping("/{id}")
    public ItemResource deleteItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);
        return null;
    }
}

