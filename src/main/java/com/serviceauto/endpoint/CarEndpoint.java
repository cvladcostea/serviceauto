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

import com.entity.CarEntity;
import com.serviceauto.dao.ICarEntityDao;
import com.serviceauto.endpoint.model.CarModel;
import com.serviceauto.service.CarService;

@Controller
@ComponentScan
@RequestMapping(value = "/serviceauto/car")
public class CarEndpoint {

	@Autowired
	private CarService carService;

	@Autowired
	public ICarEntityDao carEntityDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAllCars(Model model) {
		model.addAttribute("car", new CarEntity());
		model.addAttribute("allCars", (ArrayList<CarEntity>) carService.getAllCars());
		return "service_templates/service_auto_all_cars_from_service";
	}

	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public String redirectToRegisterCarForUser(Model model, @PathVariable("userId") long userId) {
		model.addAttribute("userId");
		model.addAttribute("caradd", new CarModel());
		return "service_templates/serviceauto_redirect_register_car";
	}

	@RequestMapping(value = "/register/{userId}", method = RequestMethod.POST)
	public String registerCarForAdmin(@ModelAttribute("caradd") CarModel carModel,
			@PathVariable("userId") long userId) {
		carService.registerCarForUser(carModel, userId);
		return "service_templates/service_auto_admin_main_page";
	}

	@RequestMapping(value = "/admin/{userId}", method = RequestMethod.GET)
	public String getCarsforUser(Model model, @PathVariable("userId") long userId) {
		model.addAttribute("car", new CarEntity());
		model.addAttribute("allCars", carService.getAllCarsForUser(userId));
		return "service_templates/service_auto_all_cars_for_user";
	}

	@RequestMapping(value = "/op/{carId}", method = RequestMethod.GET)
	public String redirectToUpdateCarPage(Model model, @PathVariable("carId") long carId) {
		model.addAttribute("carId");
		model.addAttribute("car", new CarEntity());
		return "service_templates/service_auto_update_delete_for_car";
	}

	@RequestMapping(value = "/delete/{carId}", method = RequestMethod.POST)
	public String deleteCar(@PathVariable("carId") long carId) {
		carService.deleteCar(carId);
		return "service_templates/service_auto_admin_main_page";

	}

	@RequestMapping(value = "/update/{carId}", method = RequestMethod.POST)
	public String updateCar(@PathVariable("carId") long carId, @ModelAttribute("car") CarModel model) {
		carService.updateCar(model, carId);
		return "service_templates/service_auto_admin_main_page";
	}
}
