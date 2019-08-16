package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.model.User;

public interface UserGateway {

    User createUser(UserForm userForm);
}
