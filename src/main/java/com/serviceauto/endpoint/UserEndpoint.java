package com.serviceauto.endpoint;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.UserEntity;
import com.serviceauto.endpoint.model.UserModel;
import com.serviceauto.service.UserService;

@Controller
@ComponentScan
@RequestMapping(value = "/serviceauto")
public class UserEndpoint {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String redirectToMainPage() {
		return "service_templates/service_auto_main_page";
	}

	@RequestMapping(value = "/created", method = RequestMethod.GET)
	public String accountCreated() {
		return "service_templates/service_auto_account_created";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String redirectToRegisterPage(Model model) {
		model.addAttribute("useradd", new UserModel());
		return "service_templates/service_auto_register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("useradd") UserModel userModel) {
		userService.registerUser(userModel);
		return "service_templates/service_auto_account_created";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String getContact() {
		return "service_templates/service_auto_contact";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage() {
		return "service_templates/service_auto_admin_page";
	}

	@RequestMapping(value = "/admin/all/users", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		model.addAttribute("user", new UserEntity());
		model.addAttribute("allUser", (ArrayList<UserEntity>) userService.getAllUsers());
		return "service_templates/service_auto_all_users_from_service";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminToMainPage() {
		return "service_templates/service_auto_admin_main_page";
	}

	@RequestMapping(value = "/user/op/{userId}", method = RequestMethod.GET)
	public String updateUser(Model model, @PathVariable("userId") long userId) {
		model.addAttribute("userId");
		model.addAttribute("user", new UserEntity());
		return "service_templates/service_auto_update_delete_page_user";
	}

	@RequestMapping(value = "/user/op/delete/{userId}", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("userId") long userId) {
		userService.deleteUser(userId);
		return "service_templates/service_auto_admin_main_page";
	}

	@RequestMapping(value= "/user/op/update/{userId}",method = RequestMethod.POST)
	public String userUpdate(@ModelAttribute("user") UserModel model, @PathVariable("userId") long userId) {
		userService.userUpdate(model, userId);
		return "service_templates/service_auto_admin_main_page";
	}
}