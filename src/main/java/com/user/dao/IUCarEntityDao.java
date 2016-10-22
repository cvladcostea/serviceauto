package com.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.CarEntity;

public interface IUCarEntityDao extends JpaRepository<CarEntity, Long>{

	
	@Query(name ="CarEntity.getAllCarsForUser")
	public List<CarEntity> getAllCarsForUser(@Param("userId")long id);
	
}
