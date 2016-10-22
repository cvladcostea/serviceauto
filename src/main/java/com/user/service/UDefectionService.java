package com.user.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.DefectionEntity;
import com.user.controller.IUDefectionController;
import com.user.endpoint.model.UDefectionModel;

@Service
public class UDefectionService {

	@Autowired
	private IUDefectionController defectionController;

	public List<DefectionEntity> uGetAllDefectionForCar(long id) {
		List<DefectionEntity> defectionList = new ArrayList<DefectionEntity>();
		try {
			defectionList = defectionController.uGetAllDefectionForCar(id);
		} catch (IllegalArgumentException e) {

		}
		return defectionList;
	}

	public void uRegisterDefectionForCar(long carId, UDefectionModel model, Principal principal) {
		assertMethod(model);
		defectionController.uRegisterDefectionForCar(carId, model, principal);
	}

	public void assertMethod(UDefectionModel model) {
		Assert.assertNotNull(model);
		Assert.assertNotNull(model.getAppointmentData());
		Assert.assertNotNull(model.getDescription(), "ERROR");
	}

	public void uUpdateDefection(UDefectionModel model, long defectionId) {
		defectionController.uUpdateDefection(defectionId, model);
	}

	public void uDeleteDefection(long defectionId) {
		defectionController.uDeleteDefection(defectionId);

	}

}
