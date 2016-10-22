package com.serviceauto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.DefectionEntity;

@Repository
public interface IDefectionDao extends JpaRepository<DefectionEntity, Long> {
	
}
