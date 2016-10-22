package com.serviceauto.endpoint.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarModel {

	@JsonProperty(value = "model")
	private String model;

	@JsonProperty(value = "brand")
	private String brand;

	@JsonProperty(value = "manufactureYear")
	private Long manufactureYear;

	public CarModel() {

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
