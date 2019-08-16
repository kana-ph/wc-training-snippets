package com.whitecloak.training.inventory.persistence.repository;

import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ItemPagination extends CrudRepository<ItemEntity, Long>, PagingAndSortingRepository <ItemEntity, Long>{
    Page<ItemEntity> findAll(Pageable pageable);

}

