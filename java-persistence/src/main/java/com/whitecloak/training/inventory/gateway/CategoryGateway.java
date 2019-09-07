package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.model.Item;

import java.util.Set;

public interface CategoryGateway {

    Category createCategory(String categoryName/*, Set<Item> items*/);
}
