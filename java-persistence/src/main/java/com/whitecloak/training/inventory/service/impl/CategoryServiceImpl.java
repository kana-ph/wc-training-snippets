package com.whitecloak.training.inventory.service.impl;

import com.whitecloak.training.inventory.controller.request.CategoryForm;
import com.whitecloak.training.inventory.controller.response.CategoryResource;
import com.whitecloak.training.inventory.gateway.CategoryGateway;
import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.persistence.entity.CategoryEntity;
import com.whitecloak.training.inventory.persistence.repository.CategoryRepository;
import com.whitecloak.training.inventory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryGateway categoryGateway;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryGateway categoryGateway, CategoryRepository categoryRepository) {
        this.categoryGateway = categoryGateway;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResource createCategory(CategoryForm categoryForm) {
        Category category = categoryGateway.createCategory(categoryForm.getCategoryName()/*, categoryForm.get*/);

        CategoryResource categoryResponse = new CategoryResource();

        categoryResponse.setId(category.getId());
        categoryResponse.setCategoryName(category.getCategoryName());

        return categoryResponse;
    }

    @Override
    public CategoryEntity fetchCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
