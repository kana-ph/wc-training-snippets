package com.whitecloak.training.inventory.persistence.entity;

import com.whitecloak.training.inventory.model.Category;

import javax.persistence.*;

@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private UserEntity ownerId;

    @ManyToOne
    @JoinColumn
    private CategoryEntity categoryId;

    @Column
    private String status;


    public Long getId() {return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UserEntity ownerId) {
        this.ownerId = ownerId;
    }

    public CategoryEntity getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryEntity categoryId) {
        this.categoryId = categoryId;
    }

    //    public long getOwnerId() {
//        return ownerId;
//    }
//    public void setOwnerId(long ownerId){
//        this.ownerId = ownerId;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}