package com.serviceauto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserEntity;

@Repository
public interface IUserEntityDao extends JpaRepository<UserEntity, Long> {
  public UserEntity findByUsername(String username);

}
