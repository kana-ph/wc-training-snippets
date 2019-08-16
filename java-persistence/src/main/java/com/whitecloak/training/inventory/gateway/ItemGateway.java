package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.model.Item;
import org.springframework.data.domain.Page;

public interface ItemGateway {

    Item create(ItemForm form);
    Page<Item> all(int page, int size);
    Page<Item> all(String category, int page, int size);
    Item get(Long id);
    void delete(Long id);

}
