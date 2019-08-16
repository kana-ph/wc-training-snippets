package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.controller.response.UserResource;
import com.whitecloak.training.inventory.gateway.UserGateway;
import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import com.whitecloak.training.inventory.service.CategoryService;
import com.whitecloak.training.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserGateway userGateway;

    @Autowired
    public UserServiceImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserResource create(UserForm form){
        User user=userGateway.create(form.getName());
        UserResource userResource=new UserResource();
        userResource.setId(user.getId());
        userResource.setName(user.getName());
        return userResource;
    }
}
