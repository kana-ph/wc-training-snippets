package com.whitecloak.training.inventory.persistence.repository;

import com.whitecloak.training.inventory.model.Item;
import com.whitecloak.training.inventory.persistence.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import javax.swing.text.html.Option;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends Repository<ItemEntity, Long> {

    ItemEntity save(ItemEntity entity);
    ItemEntity findById(Long id);
}
