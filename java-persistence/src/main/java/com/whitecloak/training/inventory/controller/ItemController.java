package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.service.CategoryService;
import com.whitecloak.training.inventory.service.ItemService;
import com.whitecloak.training.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

    private final ItemService itemService;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public ItemController(ItemService itemService, UserService userService, CategoryService categoryService) {
        this.itemService = itemService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @PostMapping("/items")
    public ItemResource createItem(@RequestBody ItemForm itemForm) {
        return itemService.createItem(itemForm, userService.fetchUserById(itemForm.getOwner()), categoryService.fetchCategoryById(itemForm.getCategory()));
    }

    @GetMapping("/items/{id}")
    public ItemResource fetchItemById(@PathVariable Long id){
        return new ItemResource(itemService.fetchItemById(id).getId(), itemService.fetchItemById(id).getItemName(), itemService.fetchItemById(id).getOwner(), itemService.fetchItemById(id).getCategory());
    }
}
