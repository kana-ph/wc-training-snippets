package com.whitecloak.training.inventory.service;

import com.whitecloak.training.inventory.controller.request.ItemForm;
import com.whitecloak.training.inventory.controller.response.ItemPaginationResponse;
import com.whitecloak.training.inventory.controller.response.ItemResource;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {

    ItemResource create(ItemForm form);
    ItemEntity getItem(Long id);
//    Page<ItemEntity> findAllByPage(Pageable pageable);
    String deleteItem(Long id);
    ItemPaginationResponse<ItemEntity> findAllByPage(Pageable pageable);
   // List<ItemEntity> findAllByPage(Integer pageNo, Integer pageSize);

    //List<Item> getAllItems(ItemResource item);
    //ItemResource deleteItem(Long id, ItemResource item);
}
