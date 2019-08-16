package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.gateway.UserGateway;
import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGateWayImpl implements UserGateway {

    private final UserRepository userRepository;

    @Autowired
    public UserGateWayImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(UserForm userForm) {
        UserEntity entity = new UserEntity();
        entity.setName(userForm.getName());

        UserEntity savedEntity = userRepository.save(entity);

        User user = new User();
        user.setId(savedEntity.getId());
        user.setName(savedEntity.getName());
        return user;
    }

}
