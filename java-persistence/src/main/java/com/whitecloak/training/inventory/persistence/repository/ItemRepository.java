package com.whitecloak.training.inventory.persistence.repository;

import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface ItemRepository extends Repository<ItemEntity, Long> {

    ItemEntity save(ItemEntity entity);
    ItemEntity findById(Long id);
    Page<ItemEntity> findAll(Pageable pageable);
    Page<ItemEntity> findAllByCategory_Name(String category, Pageable pageable);


}
