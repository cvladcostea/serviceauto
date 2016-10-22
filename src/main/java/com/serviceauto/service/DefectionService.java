package com.serviceauto.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.DefectionEntity;
import com.serviceauto.controller.IDefectionController;
import com.serviceauto.endpoint.model.DefectionModel;

@Service
public class DefectionService {

	@Autowired
	private IDefectionController defectionController;

	public List<DefectionEntity> getAllDefection() {
		List<DefectionEntity> defectionList = new ArrayList<DefectionEntity>();
		defectionList = defectionController.findAll();
		return defectionList;
	}

	public List<DefectionEntity> getDefectionForCar(long carId) {
		List<DefectionEntity> defection = new ArrayList<DefectionEntity>();
		try {
			defection = defectionController.getDefectionForCar(carId);
		} catch (IllegalArgumentException e) {

		}
		return defection;
	}

	public void registerDefection(long carId, DefectionModel model) {
		assertDefectionModel(model);
		defectionController.registerDefection(carId, model);
	}

	private void assertDefectionModel(DefectionModel model) {
		Assert.assertNotNull(model.getDescription(), "Error");
		Assert.assertNotNull(model.getAppointmentData());
	}

	public void updateDefectionForCar(long defectionId, DefectionModel model) {
		assertDefectionModel(model);
		defectionController.updateDefectionForCar(model, defectionId);
	}

	public void deleteDefection(long defectionId) {
		defectionController.deleteDefection(defectionId);
	}

}
