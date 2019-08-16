package com.whitecloak.training.inventory.persistence.repository;

import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemPaginationRepo extends PagingAndSortingRepository<ItemEntity, Long> {
}
