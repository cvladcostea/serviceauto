package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERROLE_TABLE")
public class UserRoleEntity {

	@Id
	@GeneratedValue
	@Column(name = "USER_ROLE_ID")
	private Long userRoleId;

	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "ROLE")
	private String role;

	public UserRoleEntity() {

	}
	public UserRoleEntity(Long userId, String role){
		this.userId=userId;
		this.role= role;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Long getUserId() {
		return userId;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}