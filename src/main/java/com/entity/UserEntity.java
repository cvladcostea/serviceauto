package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TABLE")
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ENABLED")
	private int enabled;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<CarEntity> carList = new ArrayList<CarEntity>();

	public UserEntity() {

	}
	public UserEntity(String username,String password,String email){
		this.username=username;
		this.password=password;
		this.email=email;
	}

	public UserEntity(UserEntity user) {
		this.id = user.id;
		this.username = user.username;
		this.email = user.email;
		this.password = user.password;
		this.enabled = user.enabled;
	}

	public List<CarEntity> getCarList() {
		return carList;
	}

	public void setCarList(List<CarEntity> carList) {
		this.carList = carList;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

}
