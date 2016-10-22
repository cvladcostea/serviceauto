package com.serviceauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.CarEntity;
import com.entity.DefectionEntity;
import com.serviceauto.dao.ICarEntityDao;
import com.serviceauto.dao.IDefectionDao;
import com.serviceauto.endpoint.model.DefectionModel;

@Component
public class DefectionController implements IDefectionController {

	@Autowired
	private IDefectionDao defectionDao;

	@Autowired
	private ICarEntityDao carEntityDao;

	@Override
	public List<DefectionEntity> findAll() {
		List<DefectionEntity> defection = defectionDao.findAll();
		return defection;
	}

	@Override
	public List<DefectionEntity> getDefectionForCar(long carId) {
		CarEntity car = carEntityDao.findOne(carId);
		List<DefectionEntity> defection = car.getDefection();
		return defection;
	}

	@Override
	public void registerDefection(long carId, DefectionModel model) {
		CarEntity car = carEntityDao.findOne(carId);
		DefectionEntity defection = new DefectionEntity();
		defection.setCar(car);
		defection.setAppointmentData(model.getAppointmentData());
		defection.setDescription(model.getDescription());
		defectionDao.saveAndFlush(defection);
	}

	@Override
	public void updateDefectionForCar(DefectionModel model, long defectionId) {
		DefectionEntity defection = defectionDao.findOne(defectionId);
		defection.setAppointmentData(model.getAppointmentData());
		defection.setDescription(model.getDescription());
		defectionDao.saveAndFlush(defection);
	}

	@Override
	public void deleteDefection(long defectionId) {
		DefectionEntity defection = defectionDao.findOne(defectionId);
		defectionDao.delete(defection);
	}
}
