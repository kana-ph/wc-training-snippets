package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.UserGateway;
import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    @Autowired
    public UserGatewayImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String userName){
        UserEntity userEntity = new UserEntity();

        userEntity.setUserName(userName);

        UserEntity savedUserEntity = userRepository.save(userEntity);

        User user = new User();

        user.setId(savedUserEntity.getId());
        user.setUserName(savedUserEntity.getUserName());

        return user;
    }
}
