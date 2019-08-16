package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.model.User;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;

public interface UserGateway {

    User createUser(String userName);
}
