package com.user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.entity.CarEntity;
import com.entity.UserEntity;
import com.user.dao.IUCarEntityDao;
import com.user.dao.IUUserEntityDao;
import com.user.endpoint.model.UCarModel;

@Component
public class UCarController implements IUCarController {

	@Autowired
	private IUCarEntityDao carEntityDao;

	@Autowired
	private IUUserEntityDao userEntityDao;

	@Override
	public void uRegisterCarForUser(UCarModel carModel, Principal principal) {
		UserEntity user = userEntityDao.findByUsername(principal.getName());
		CarEntity car = new CarEntity();
		car.setUser(user);
		car.setBrand(carModel.getBrand());
		car.setModel(carModel.getModel());
		car.setManufactureYear(carModel.getManufactureYear());
		carEntityDao.saveAndFlush(car);
	}

	@Override
	public List<CarEntity> viewAllCarForUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserEntity user = (UserEntity) authentication.getPrincipal();
		Long id = user.getId();
		List<CarEntity> carList = carEntityDao.getAllCarsForUser(id);
		return carList;
	}

	@Override
	public void uDeleteCar(long carId) {
		CarEntity car = carEntityDao.findOne(carId);
		carEntityDao.delete(car);
	}

	@Override
	public void uUpdateCar(UCarModel carModel, long carId) {
		CarEntity car = carEntityDao.findOne(carId);
		car.setBrand(carModel.getBrand());
		car.setManufactureYear(carModel.getManufactureYear());
		car.setModel(carModel.getModel());
		carEntityDao.saveAndFlush(car);
	}

}
