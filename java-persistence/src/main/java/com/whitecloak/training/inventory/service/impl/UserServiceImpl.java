package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.controller.response.UserResource;
import com.whitecloak.training.inventory.gateway.UserGateway;
import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.service.UserService;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {

    private final UserGateway userGateway;

    public UserServiceImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserResource create(UserForm form) {
        User user = userGateway.create(form);

        UserResource userResource = new UserResource();
        userResource.setId(user.getId());
        userResource.setName(user.getName());
        return userResource;
    }

    @Override
    public UserEntity getUser(Long id) {
        return userGateway.findBy(id);
    }

}