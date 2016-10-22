package com.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserEntity;

public interface IUUserEntityDao extends JpaRepository<UserEntity, Long>{

public	UserEntity findByUsername(String name);

}
