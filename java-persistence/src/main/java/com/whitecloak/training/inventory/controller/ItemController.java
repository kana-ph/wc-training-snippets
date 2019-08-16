package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.controller.response.PageResource;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
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
    public ItemResource createItem(@RequestBody ItemForm form) {
        return itemService.create(form);
    }

    @GetMapping("/api/v1/items")
    public PageResource<ItemResource> getItems(@RequestParam(name = "category", required = false, defaultValue = "") String category,
                                               @RequestParam(name="page", defaultValue = "0") @Nullable Integer page,
                                               @RequestParam(name="size", defaultValue = "4") @Nullable Integer size) {
        return itemService.all(category, page, size);
    }

    @GetMapping("/api/v1/items/{id}")
    public ItemResource getItem(@PathVariable Long id) {
        return itemService.get(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/v1/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.delete(id);
    }

}
