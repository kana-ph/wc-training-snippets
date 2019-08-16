package com.whitecloak.training.inventory.persistence.repository;

import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity save(ItemEntity entity);
    Page<ItemEntity> findAllByDeleted(boolean status, Pageable pageable);
    Page<ItemEntity> findAllByDeletedAndCategory_Name(boolean status, String category, Pageable pageable);
    Optional<ItemEntity> findByDeletedAndId(boolean status, Long id);

}
