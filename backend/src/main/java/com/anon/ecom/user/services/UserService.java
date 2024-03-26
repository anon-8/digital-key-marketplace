package com.anon.ecom.user.services;

import com.anon.ecom.user.domain.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity save(UserEntity userEntity);
    List<UserEntity> findAll();
    Optional<UserEntity> findOne(Long id);
    boolean isExists(Long id);
    UserEntity partialUpdate(Long id, UserEntity userEntity);
    void delete(Long id);
    UserEntity getUser();
}