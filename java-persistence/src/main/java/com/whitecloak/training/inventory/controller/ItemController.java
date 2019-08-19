package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.whitecloak.training.inventory.controller.response.ItemPaginationResponse;

import java.util.List;

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
    public ItemResource getItem(@PathVariable("id") Long id){
        return itemService.getItem(id);
    }

    @DeleteMapping ("/api/v1/items/{id}")
    public String deleteItem(@PathVariable("id") Long id){
        return itemService.deleteItem(id);
    }

    @GetMapping("/api/v1/items")
    public ItemPaginationResponse<ItemEntity> fetchByPage(Pageable page){
        return itemService.findAllByPage(page);
    }

//    @GetMapping("/api/v1/items")
//    public Page<ItemEntity> fetchByPage(Pageable page){
//      //return new ItemPaginationResponse(itemService.findAllByPage(page));
//        return itemService.findAllByPage(page);
//    }

//    @GetMapping("/api/v1/items")
//    public ItemPaginationResponse<List<ItemEntity>> fetchByPage(@RequestParam(defaultValue="0") Integer pageNo,
//            @RequestParam(defaultValue = "2") Integer pageSize){
//        List<ItemEntity> list = itemService.findAllByPage(pageNo,pageSize);
//        return new ItemPaginationResponse<List<ItemEntity>>(list);
//    }

//    @GetMapping("/api/v1/items")
//    public Page<ItemResource> showItems(
//            @RequestParam(name = "category", required = false) String category) {
//
//    }




}
