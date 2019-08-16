package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;

public interface ItemService {

    ItemResource createItem(ItemForm itemForm, UserEntity userEntity, CategoryEntity categoryEntity);

    ItemEntity fetchItemById(Long id);
}
