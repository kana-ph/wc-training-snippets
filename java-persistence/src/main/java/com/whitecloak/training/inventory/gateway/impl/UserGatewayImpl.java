package com.whitecloak.training.inventory.gateway.impl;

import com.whitecloak.training.inventory.gateway.UserGateway;
import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import com.whitecloak.training.inventory.persistence.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;

    public UserGatewayImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(String name) {
        UserEntity newUser = new UserEntity();
//        newUser.setId(null);
        newUser.setName(name);

        UserEntity saveUser = userRepository.save(newUser);

        User user = new User();
        user.setId(saveUser.getId());
        user.setName(saveUser.getName());

        return user;
    }
}
