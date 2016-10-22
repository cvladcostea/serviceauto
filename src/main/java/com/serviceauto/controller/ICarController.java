package com.serviceauto.controller;

import java.util.List;

import com.entity.CarEntity;
import com.serviceauto.endpoint.model.CarModel;

public interface ICarController {
	
	
	public List<CarEntity> getAllCarsFromService();

	public List<CarEntity> getAllCarsForUser(long userId);

	public void registerCarForUser(CarModel carModel, long userId);

	public void deleteCar(long carId);

	public void updateCar(long carId, CarModel model);

}
