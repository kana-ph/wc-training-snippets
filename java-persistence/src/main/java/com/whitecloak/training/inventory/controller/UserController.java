package com.whitecloak.training.inventory.controller;

import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.controller.response.UserResource;
import com.whitecloak.training.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserResource createUser(@RequestBody UserForm userForm){
        return userService.createUser(userForm);
    }

    @GetMapping("/users/{id}")
    public UserResource fetchUserById(@PathVariable Long id){
        return new UserResource(userService.fetchUserById(id).getId(), userService.fetchUserById(id).getUserName());
    }
}
