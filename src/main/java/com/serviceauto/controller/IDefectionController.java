package com.serviceauto.controller;

import java.util.List;

import com.entity.DefectionEntity;
import com.serviceauto.endpoint.model.DefectionModel;

public interface IDefectionController {

	public List<DefectionEntity> findAll();

	public List<DefectionEntity> getDefectionForCar(long carId);

	public void registerDefection(long carId, DefectionModel model);

	public void updateDefectionForCar(DefectionModel model, long defectionId);

	public void deleteDefection(long defectionId);

}
