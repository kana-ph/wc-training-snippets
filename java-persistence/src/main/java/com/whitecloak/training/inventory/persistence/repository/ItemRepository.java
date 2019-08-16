package com.whitecloak.training.inventory.persistence.repository;

import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.repository.Repository;

public interface ItemRepository extends Repository<ItemEntity, Long> {

    ItemEntity save(ItemEntity entity);

}
