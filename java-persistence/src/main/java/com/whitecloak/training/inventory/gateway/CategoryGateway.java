package com.whitecloak.training.inventory.gateway;

import com.whitecloak.training.inventory.model.Category;
import com.whitecloak.training.inventory.model.Item;
import jdk.tools.jlink.plugin.Plugin;

import java.util.Set;

public interface CategoryGateway {
    Category create(String name);
}
