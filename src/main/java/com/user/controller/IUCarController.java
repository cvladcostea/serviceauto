package com.user.controller;

import java.security.Principal;
import java.util.List;

import com.entity.CarEntity;
import com.user.endpoint.model.UCarModel;

public interface IUCarController {

	public void uRegisterCarForUser(UCarModel carModel, Principal principal);

	public List<CarEntity> viewAllCarForUser();

	public void uDeleteCar(long carId);

	public void uUpdateCar(UCarModel carModel, long carId);

}
