package com.user.endpoint;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.DefectionEntity;
import com.user.endpoint.model.UDefectionModel;
import com.user.service.UDefectionService;

@Controller
@ComponentScan
@RequestMapping(value = "/serviceauto/user/car/defection")
public class UDefectionEndpoint {

	@Autowired
	private UDefectionService defectionService;

	@RequestMapping(value = "{carId}")
	public String uGetAllDefectionForCar(Model model, @PathVariable(value = "carId") long id) {
		model.addAttribute("defection", new DefectionEntity());
		model.addAttribute("allDefection", defectionService.uGetAllDefectionForCar(id));
		return "user_templates/user_view_all_defection_for_car";
	}

	@RequestMapping(value = "/register/{carId}", method = RequestMethod.GET)
	public String uRedirectToRegisterDefectionForCar(Model model, @PathVariable("carId") long carId) {
		model.addAttribute("carId");
		model.addAttribute("defection", new DefectionEntity());
		return "user_templates/user_register_defection";
	}

	@RequestMapping(value = "/register/{carId}", method = RequestMethod.POST)
	public String uRegisterDefectionForCar(@PathVariable("carId") long carId,
			@ModelAttribute("defection") UDefectionModel model, Principal principal) {
		defectionService.uRegisterDefectionForCar(carId, model, principal);
		return "user_templates/user_view_all_cars_for_user";
	}

	@RequestMapping(value = "/op/{defectionId}", method = RequestMethod.GET)
	public String uRedirectToDefectionOperation(Model model, @PathVariable("defectionId") long defectionId) {
		model.addAttribute("defectionId");
		model.addAttribute("defectionUpdate", new DefectionEntity());
		return "user_templates/user_defection_update_delete";
	}

	@RequestMapping(value = "/update/{defectionId}", method = RequestMethod.POST)
	public String uUpdateDefection(@ModelAttribute("defectionUpdate") UDefectionModel model,
			@PathVariable("defectionId") Long defectionId) {
		defectionService.uUpdateDefection(model, defectionId);
		return "user_templates/user_redirectToUserMainPage";
	}

	@RequestMapping(value = "/delete/{defectionId}", method = RequestMethod.POST)
	public String uDeleteDefection(@PathVariable("defectionId") long defectionId) {
		defectionService.uDeleteDefection(defectionId);
		return "user_templates/user_redirectToUserMainPage";
	}

}
