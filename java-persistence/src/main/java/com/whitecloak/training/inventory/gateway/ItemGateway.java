package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemPaginationResponse;
import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.domain.Pageable;

public interface ItemGateway {
    Item create(ItemForm form);
    String deleteItem(Long id);
    Item getItem(Long id);
    ItemPaginationResponse<ItemEntity> showItems(Pageable pageable);

}
