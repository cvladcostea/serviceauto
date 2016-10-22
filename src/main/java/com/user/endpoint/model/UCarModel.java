package com.user.endpoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UCarModel {

	@JsonProperty(value = "model")
	private String model;

	@JsonProperty(value = "brand")
	private String brand;

	@JsonProperty(value = "manufactureYear")
	private Long manufactureYear;

	public UCarModel() {

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

}
