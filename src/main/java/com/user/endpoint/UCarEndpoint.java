package com.user.endpoint;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.CarEntity;
import com.user.endpoint.model.UCarModel;
import com.user.service.UCarService;

@Controller
@ComponentScan
@RequestMapping(value = "/serviceauto/user/car")
public class UCarEndpoint {

	@Autowired
	private UCarService carService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerCarForUser(Model model) {
		model.addAttribute("caradd", new CarEntity());
		return "user_templates/user_register_car";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerCarforUser(@ModelAttribute("caradd") UCarModel carModel, Principal principal) {
		carService.uRegisterCarForUser(carModel, principal);
		return "user_templates/user_view_all_cars_for_user";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAllCarForUser(Model model) {
		model.addAttribute("car", new CarEntity());
		model.addAttribute("allCars", (ArrayList<CarEntity>) carService.viewAllCarForUser());
		return "user_templates/user_view_all_cars_for_user";
	}

	public String testam(@PathVariable("carId") long carId) {
		return "user_templates/test";
	}

	@RequestMapping(value = "/delete/{carId}")
	public String uRedirectToMain(Model model, @PathVariable("carId") long carId) {
		model.addAttribute("carId", carId);
		model.addAttribute("carUpdate", new CarEntity());
		return "user_templates/user_update_and_delete_page";
	}

	@RequestMapping(value = "/update/{carId}", method = RequestMethod.POST)
	public String uUpdateCar(@ModelAttribute("carUpdate") UCarModel carModel, @PathVariable("carId") long carId) {
		carService.uUpdateCar(carModel, carId);
		return "redirect:/serviceauto/user/car/view";
	}

	@RequestMapping(value = "/delete/{carId}", method = RequestMethod.POST)
	public String uDeleteCar(@PathVariable("carId") long carId) {
		carService.uDeleteCar(carId);
		return "user_templates/user_redirectToUserMainPage";
	}
}
