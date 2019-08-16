package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.request.UserForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;

public interface ItemService {
    ItemResource create(ItemForm itemForm, UserForm userForm, CategoryForm categoryForm);
}
