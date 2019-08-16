package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {

    ItemResource create(ItemForm form);
    ItemResource getUser(Long id);
    Page<ItemResource> findAll(Pageable pageable);
    Page<ItemResource> findAllByCategory_Name(String category, Pageable pageable);
    void delete(Long id);
}
