package com.serviceauto.controller;

import com.serviceauto.endpoint.model.UserModel;

public interface IUserController {

	public void deleteUser(long userId);

	public void userUpdate(UserModel model, long userId);

}
