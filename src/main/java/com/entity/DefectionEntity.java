package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "DEFECTION_TABLE")
public class DefectionEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "APPOINTMENT_DATA")
	private Long appointmentData;

	@ManyToOne
	@JoinColumn(name = "CAR_ID")
	private CarEntity car;

	public DefectionEntity() {

	}

	public DefectionEntity(String description, Long appointmentData) {
		super();
		this.description = description;
		this.appointmentData = appointmentData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CarEntity getCar() {
		return car;
	}

	public void setCar(CarEntity car) {
		this.car = car;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAppointmentData() {
		return appointmentData;
	}

	public void setAppointmentData(Long appointmentDate) {
		this.appointmentData = appointmentDate;
	}

}
