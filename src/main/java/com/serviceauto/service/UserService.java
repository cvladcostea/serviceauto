package com.serviceauto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.entity.UserEntity;
import com.entity.UserRoleEntity;
import com.serviceauto.controller.IUserController;
import com.serviceauto.dao.IUserEntityDao;
import com.serviceauto.dao.IUserRoleEntityDao;
import com.serviceauto.endpoint.model.UserModel;

@Service
public class UserService {

	@Autowired
	private IUserEntityDao userEntityDao;

	@Autowired
	private IUserRoleEntityDao userRoleEntityDao;

	@Autowired
	private IUserController userController;

	public void registerUser(UserModel userModel) {
		assertUserModel(userModel);
		register(userModel);
	}

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private void register(UserModel userModel) {
		UserEntity userEntity = userEntityDao.findByUsername(userModel.getUsername());
		Assert.isNull(userEntity, "The user is already registred !!");
		userEntity = userEntityDao.saveAndFlush(createUserEntity(userModel));
		UserRoleEntity userRoleEntity = new UserRoleEntity();
		userRoleEntity.setRole("ROLE_USER");
		userRoleEntity.setUserId(userEntity.getId());
		userRoleEntityDao.saveAndFlush(userRoleEntity);

	}

	private UserEntity createUserEntity(UserModel userModel) {
		UserEntity userEntity = new UserEntity();
		userEntity.setEnabled(1);
		userEntity.setEmail(userModel.getEmail());
		userEntity.setUsername(userModel.getUsername());
		userEntity.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		return userEntity;
	}

	public List<UserEntity> getAllUsers() {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList = userEntityDao.findAll();
		return userList;
	}

	private void assertUserModel(UserModel model) {
		Assert.notNull("The username must not be null", model.getPassword());
		Assert.notNull("The password must not be null", model.getUsername());
		Assert.notNull("The email must not be null", model.getEmail());
	}

	public void deleteUser(long userId) {
		try {
			userController.deleteUser(userId);
		} catch (IllegalArgumentException e) {

		}
	}

	public void userUpdate(UserModel model, long userId) {
		assertUserModel(model);
		userController.userUpdate(model, userId);
	}

}