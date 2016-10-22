package com.user.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CarEntity;
import com.user.controller.IUCarController;
import com.user.endpoint.model.UCarModel;

@Service
public class UCarService {

	@Autowired
	private IUCarController carController;

	public void uRegisterCarForUser(UCarModel carModel, Principal principal) {
		assertRegister(carModel);
		carController.uRegisterCarForUser(carModel, principal);
	}

	public void assertRegister(UCarModel carModel) {
		Assert.assertNotNull(carModel);
		Assert.assertNotNull(carModel.getBrand(), "ERROR");
		Assert.assertNotNull(carModel.getModel(), "ERROR");
		Assert.assertNotNull(carModel.getManufactureYear());
	}

	public List<CarEntity> viewAllCarForUser() {
		List<CarEntity> carList = new ArrayList<CarEntity>();
///*	CarDto carDto=new CarDto();
//	carDto.setName();
//	carDto.setModel();*/
		try{
			carList= carController.viewAllCarForUser();
		}catch(IllegalArgumentException e){
			
		}
				
		return carList;
	}

	public void uDeleteCar(long carId) {
		carController.uDeleteCar(carId);
		
	}

	public void uUpdateCar(UCarModel carModel, long carId) {
		assertMethod(carModel);
		carController.uUpdateCar(carModel,carId);
	}

	private void assertMethod(UCarModel carModel) {
		Assert.assertNotNull(carModel.getBrand(),"Error");
		Assert.assertNotNull(carModel.getModel(),"Error");
		Assert.assertNotNull(carModel.getManufactureYear());
	}

}
