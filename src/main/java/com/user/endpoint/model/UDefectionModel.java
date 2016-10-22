package com.user.endpoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UDefectionModel {

	@JsonProperty(value = "description")
	private String description;

	@JsonProperty(value = "appointmentData")
	private Long appointmentData;

	public UDefectionModel() {

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

	public void setAppointmentData(Long appointmentData) {
		this.appointmentData = appointmentData;
	}

}
