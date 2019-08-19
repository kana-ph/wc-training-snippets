package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.UserGateway;
import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class UserGatewayImpl implements UserGateway {
    private final UserRepository userRepository;

    @Autowired
    UserGatewayImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        UserEntity savedEntity = userRepository.save(userEntity);

        User user = new User();
        user.setId(savedEntity.getId());
        user.setName(savedEntity.getName());
        return user;
    }
}
