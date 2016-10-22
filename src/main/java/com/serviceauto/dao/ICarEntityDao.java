package com.serviceauto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.CarEntity;

public interface ICarEntityDao extends JpaRepository<CarEntity, Long> {
	@Query(name = "CarEntity.getAllCarsForUser")
	public List<CarEntity> getAllCarsForUser(@Param("userId") long userId);

	@Query("select a from CarEntity a")
	public List<CarEntity> findAllCars();

}

// @Query("select a.role from UserRoleEntity a, UserEntity b where b.username=?1
// and a.id=b.id")
// public List<String> findRoleByUserName(String username);