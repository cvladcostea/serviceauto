package com.serviceauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.entity.UserEntity;
import com.entity.UserRoleEntity;
import com.serviceauto.dao.IUserEntityDao;
import com.serviceauto.dao.IUserRoleEntityDao;
import com.serviceauto.endpoint.model.UserModel;

@Component
public class UserController implements IUserController {

	@Autowired
	private IUserEntityDao userEntityDao;

	@Autowired
	private IUserRoleEntityDao roleEntityDao;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void deleteUser(long userId) {
		UserEntity user = userEntityDao.findOne(userId);
		UserRoleEntity role = roleEntityDao.findOne(userId);
		roleEntityDao.delete(role);
		userEntityDao.delete(user);
	}

	public void userUpdate(UserModel model, long userId) {
		UserEntity user = new UserEntity();
		user = userEntityDao.findOne(userId);
		user.setEmail(model.getEmail());
		user.setPassword(bCryptPasswordEncoder.encode(model.getPassword()));
		user.setUsername(model.getUsername());
		userEntityDao.saveAndFlush(user);
	}

}
