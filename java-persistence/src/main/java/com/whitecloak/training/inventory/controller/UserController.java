package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.controller.response.UserResource;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/items")
    public UserResource createUser(@RequestBody UserForm form) {
        return userService.create(form);
    }

    @GetMapping("/api/v1/items/{id}")
    public UserEntity getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);

    }

}

