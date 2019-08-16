package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.repository.ItemRepository;
import com.whitecloak.training.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ItemResource getItems(@PathVariable("id") Long id) {


//        if(itemService.getUser(id)!=null){
//            return itemService.getUser(id);
//        }else {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID is not valid!");
//        }

        try {
            return itemService.getUser(id);
        }catch (NullPointerException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID is not valid!",ex);
        }

    }



    @DeleteMapping("/api/v1/items/{id}")
    public void delItem(@PathVariable("id") Long id){
        itemService.delete(id);
    }

//    @GetMapping("/api/v1/items")
//    public Page<ItemResource> itemsPageable(Pageable pageable){
//        return itemService.findAll(pageable);
//    }


    @GetMapping("/api/v1/items")
    public Page<ItemResource> itemsPageableCategory(@RequestParam(name="category",required = false,defaultValue = "")String category, Pageable pageable){
        if(category.equals("")){
            return itemService.findAll(pageable);
        }else{
            return itemService.findAllByCategory_Name(category,pageable);
        }

    }
}
