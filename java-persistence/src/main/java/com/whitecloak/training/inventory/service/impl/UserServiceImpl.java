package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.response.CategoryResource;
import com.whitecloak.training.inventory.controller.response.UserResource;
import com.whitecloak.training.inventory.gateway.UserGateway;
import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.service.UserService;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {

    private final UserGateway userGateway;

    UserServiceImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserResource create(String name){
        User user = userGateway.create(name);

        UserResource userResource = new UserResource();
        userResource.setId(user.getId());
        userResource.setName(user.getName());
        return userResource;
    }
}
