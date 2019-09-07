package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.controller.response.UserResource;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;

public interface UserService {

    UserResource createUser(UserForm userForm);

    UserEntity fetchUserById(Long id);
}
