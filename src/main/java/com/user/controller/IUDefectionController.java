package com.user.controller;

import java.security.Principal;
import java.util.List;

import com.entity.DefectionEntity;
import com.user.endpoint.model.UDefectionModel;

public interface IUDefectionController {

	public List<DefectionEntity> uGetAllDefectionForCar(long id);

	public void uRegisterDefectionForCar(long carId, UDefectionModel model, Principal principal);

	public void uUpdateDefection(long defectionId, UDefectionModel model);

	public void uDeleteDefection(long defectionId);
}
