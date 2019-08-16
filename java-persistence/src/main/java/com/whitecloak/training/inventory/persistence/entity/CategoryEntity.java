package com.whitecloak.training.inventory.persistence.entity;

import com.whitecloak.training.inventory.model.Item;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany
    private Set<ItemEntity> items;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setItems(Set<ItemEntity> items) { this.items = items; }
}
