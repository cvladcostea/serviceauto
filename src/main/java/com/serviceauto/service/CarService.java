package com.serviceauto.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CarEntity;
import com.serviceauto.controller.ICarController;
import com.serviceauto.dao.ICarEntityDao;
import com.serviceauto.dao.IUserEntityDao;
import com.serviceauto.endpoint.model.CarModel;

@Service
public class CarService {

	@Autowired
	private ICarController carController;

	@Autowired
	private ICarEntityDao carEntityDao;

	@Autowired
	private IUserEntityDao userEntityDao;

	public List<CarEntity> getAllCars() {
		List<CarEntity> carList = new ArrayList<CarEntity>();
		carList = carController.getAllCarsFromService();
		return carList;
	}

	public void registerCarForUser(CarModel carModel, long userId) {
		assertCarModel(carModel);
		carController.registerCarForUser(carModel, userId);

	}

	private void assertCarModel(CarModel model) {
		Assert.assertNotNull(model.getBrand(), "Error");
		Assert.assertNotNull(model.getModel(), "Error");
		Assert.assertNotNull(model.getManufactureYear());
	}

	public List<CarEntity> getAllCarsForUser(long userId) {
		List<CarEntity> carEntity = new ArrayList<CarEntity>();
		try {
			carEntity = carController.getAllCarsForUser(userId);
		} catch (IllegalArgumentException e) {
		}
		return carEntity;
	}

	public void deleteCar(long carId) {
		carController.deleteCar(carId);
	}

	public void updateCar(CarModel model, long carId) {
		assertCarModel(model);
		carController.updateCar(carId, model);
	}

}
