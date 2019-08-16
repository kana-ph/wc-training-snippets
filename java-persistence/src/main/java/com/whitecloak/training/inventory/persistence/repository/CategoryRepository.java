package com.whitecloak.training.inventory.persistence.repository;

import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import org.springframework.data.repository.Repository;

public interface CategoryRepository extends Repository<CategoryEntity, Long> {

    CategoryEntity save(CategoryEntity entity);
}
