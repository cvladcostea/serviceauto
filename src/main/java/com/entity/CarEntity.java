package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
		@NamedQuery(name = "CarEntity.getAllCarsForUser", query = "SELECT c FROM CarEntity c WHERE c.user.id = :userId") })
@Entity
@Table(name = "CAR_TABLE")
public class CarEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "MANUFACTURE_YEAR")
	private Long manufactureYear;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity user;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	private List<DefectionEntity> defection = new ArrayList<DefectionEntity>();


	public CarEntity() {

	}

	public CarEntity(String model, String brand, Long manufactureYear) {
		this.model = model;
		this.brand = brand;
		this.manufactureYear = manufactureYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Long getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(Long manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<DefectionEntity> getDefection() {
		return defection;
	}

	public void setDefection(List<DefectionEntity> defection) {
		this.defection = defection;
	}


}
