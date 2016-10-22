package com.user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.CarEntity;
import com.entity.DefectionEntity;
import com.entity.UserEntity;
import com.user.dao.IUCarEntityDao;
import com.user.dao.IUDefectionDao;
import com.user.dao.IUUserEntityDao;
import com.user.endpoint.model.UDefectionModel;

@Component
public class UDefectionController implements IUDefectionController {

	@Autowired
	private IUCarEntityDao carEntityDao;

	@Autowired
	private IUDefectionDao defectionEntityDao;

	@Autowired
	private IUUserEntityDao userEntityDao;

	@Override
	public List<DefectionEntity> uGetAllDefectionForCar(long id) {
		CarEntity defection = carEntityDao.findOne(id);
		return defection.getDefection();

	}

	@Override
	public void uRegisterDefectionForCar(long carId, UDefectionModel model, Principal principal) {
		UserEntity user = userEntityDao.findByUsername(principal.getName());
		DefectionEntity defection = new DefectionEntity();
		CarEntity car = carEntityDao.findOne(carId);
		car.setUser(user);
		defection.setCar(car);
		defection.setDescription(model.getDescription());
		defection.setAppointmentData(model.getAppointmentData());
		defectionEntityDao.saveAndFlush(defection);
	}

	@Override
	public void uUpdateDefection(long defectionId, UDefectionModel model) {
		DefectionEntity defection = defectionEntityDao.findOne(defectionId);
		defection.setDescription(model.getDescription());
		defection.setAppointmentData(model.getAppointmentData());
		defectionEntityDao.saveAndFlush(defection);
	}

	@Override
	public void uDeleteDefection(long defectionId) {
		DefectionEntity defection = defectionEntityDao.findOne(defectionId);
		defectionEntityDao.delete(defection);
	}

}
