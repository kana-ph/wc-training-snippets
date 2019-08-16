package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.controller.response.UserResource;
import com.whitecloak.training.inventory.gateway.UserGateway;
import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import com.whitecloak.training.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserGateway userGateway;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserGateway userGateway, UserRepository userRepository) {
        this.userGateway = userGateway;
        this.userRepository = userRepository;
    }

    @Override
    public UserResource createUser(UserForm userForm) {
        User user = userGateway.createUser(userForm.getUserName());

        UserResource userResponse = new UserResource();

        userResponse.setId(user.getId());
        userResponse.setUserName(user.getUserName());

        return userResponse;
    }

    @Override
    public UserEntity fetchUserById(Long id) {
        return userRepository.findById(id);
    }
}
