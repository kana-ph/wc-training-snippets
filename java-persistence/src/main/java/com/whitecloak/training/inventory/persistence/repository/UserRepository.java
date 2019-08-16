package com.whitecloak.training.inventory.persistence.repository;

import com.whitecloak.training.inventory.persistence.entity.UserEntity;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity,Long> {
    UserEntity save(UserEntity entity);
    UserEntity getById(Long id);
}
