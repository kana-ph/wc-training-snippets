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

    //@Column
    //private Set<Item> items;

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

    //public Set<Item> getItems() { return items; }

    //public void setItems(Set<Item> items) { this.items = items; }
}
