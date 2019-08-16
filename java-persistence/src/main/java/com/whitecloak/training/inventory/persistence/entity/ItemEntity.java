package com.whitecloak.training.inventory.persistence.entity;

import javax.persistence.*;

@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
//    @ManyToOne
    private Long owner;

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

//    public Long getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Long owner) {
//        this.owner = owner;
//    }

    public void setOwnerId(Long owner) {
        this.owner = owner;
    }

    public Long getOwnerId() {
        return owner;
    }
}