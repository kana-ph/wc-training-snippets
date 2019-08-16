package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemGateway {

    Item create(ItemForm form);

    Item getItem(Long id);

    Item deleteItem(Long id);

    Page<Item> getItems(Pageable pageable);

    Page<Item> getItems(String category, Pageable pageable);
}
