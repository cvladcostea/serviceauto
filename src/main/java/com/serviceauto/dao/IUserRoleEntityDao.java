package com.serviceauto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.UserRoleEntity;

@Repository
public interface IUserRoleEntityDao extends JpaRepository<UserRoleEntity, Long> {
	
	@Query("select a.role from UserRoleEntity a, UserEntity b where b.username=?1 and a.id=b.id")
	public List<String> findRoleByUserName(String username);

}
