package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemGateway {

    Item create(ItemForm form);
    Item getUser(Long id);
    Page<Item> findAll(Pageable pageable);
    Page<Item> findAllByCategory_Name(String category, Pageable pageable);
    void delete(Long id);
}
