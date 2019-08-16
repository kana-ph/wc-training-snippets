package com.whitecloak.training.inventory.persistence.repository;

import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

public interface ItemRepository extends Repository<ItemEntity, Long> {

    ItemEntity save(ItemEntity entity);

    ItemEntity findById(Long id);

    Page<ItemEntity> findAllByCategory(CategoryEntity categoryEntity, Pageable pageable);
}
