package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.controller.response.UserResource;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/v1/user")
    public UserResource create(@RequestBody UserForm form){
        return userService.create(form);
    }
}
