package com.serviceauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.CarEntity;
import com.entity.UserEntity;
import com.serviceauto.dao.ICarEntityDao;
import com.serviceauto.dao.IUserEntityDao;
import com.serviceauto.endpoint.model.CarModel;

@Component
public class CarController implements ICarController {

	@Autowired
	private ICarEntityDao carEntityDao;

	@Autowired
	private IUserEntityDao userEntityDao;

	@Override
	public List<CarEntity> getAllCarsFromService() {
		List<CarEntity> carList = carEntityDao.findAllCars();

		return carList;
	}

	@Override
	public List<CarEntity> getAllCarsForUser(long userId) {
		UserEntity user = userEntityDao.findOne(userId);
		List<CarEntity> carList = user.getCarList();
		return carList;
	}

	@Override
	public void registerCarForUser(CarModel carModel, long userId) {
		UserEntity user = userEntityDao.findOne(userId);
		CarEntity car = new CarEntity();
		car.setUser(user);
		car.setBrand(carModel.getBrand());
		car.setModel(carModel.getModel());
		car.setManufactureYear(carModel.getManufactureYear());
		carEntityDao.saveAndFlush(car);
	}

	@Override
	public void deleteCar(long carId) {
		CarEntity car = carEntityDao.findOne(carId);
		carEntityDao.delete(car);
	}

	@Override
	public void updateCar(long carId, CarModel model) {
		CarEntity car = carEntityDao.findOne(carId);
		car.setBrand(model.getBrand());
		car.setModel(model.getModel());
		car.setManufactureYear(model.getManufactureYear());
		carEntityDao.saveAndFlush(car);
	}
}
