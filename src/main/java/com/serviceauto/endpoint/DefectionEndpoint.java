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

import com.entity.DefectionEntity;
import com.serviceauto.endpoint.model.DefectionModel;
import com.serviceauto.service.DefectionService;

@Controller
@ComponentScan
@RequestMapping(value = "/serviceauto/defection")
public class DefectionEndpoint {

	@Autowired
	private DefectionService defectionService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAllDefection(Model model) {
		model.addAttribute("defection", new DefectionEntity());
		model.addAttribute("allDefection", (ArrayList<DefectionEntity>) defectionService.getAllDefection());
		return "service_templates/serviceauto_all_defection_from_service";
	}

	@RequestMapping(value = "/{carId}", method = RequestMethod.GET)
	public String getDefectionForCar(Model model, @PathVariable("carId") long carId) {
		model.addAttribute("carId");
		model.addAttribute("Defection", new DefectionEntity());
		model.addAttribute("allDefection", defectionService.getDefectionForCar(carId));
		return "service_templates/serviceauto_all_defection_for_car";

	}

	@RequestMapping(value = "/register/{carId}", method = RequestMethod.GET)
	public String redirectToRegisterPage(@PathVariable("carId") long carId, Model model) {
		model.addAttribute("carId");
		model.addAttribute("defection", new DefectionEntity());
		return "service_templates/serviceauto_register_defection_for_car";
	}

	@RequestMapping(value = "/register/{carId}", method = RequestMethod.POST)
	public String registerDefection(@PathVariable("carId") long carId,
			@ModelAttribute("defection") DefectionModel model) {
		defectionService.registerDefection(carId, model);
		return "service_templates/serviceauto_all_defection_from_service";
	}

	@RequestMapping(value = "/update/{defectionId}", method = RequestMethod.GET)
	public String redirectToDefectionUpdateDeletePage(Model model, @PathVariable("defectionId") long defectionId) {
		model.addAttribute("defectionId");
		model.addAttribute("defection", new DefectionEntity());
		return "service_templates/service_auto_redirect_to_update_delete_page";
	}

	@RequestMapping(value = "/update/{defectionId}", method = RequestMethod.POST)
	public String updateDefectionForCar(@ModelAttribute("defection") DefectionModel model,
			@PathVariable("defectionId") long defectionId) {
		defectionService.updateDefectionForCar(defectionId, model);
		return "service_templates/service_auto_admin_main_page";
	}

	@RequestMapping(value = "/delete/{defectionId}", method = RequestMethod.POST)
	public String deleteDefection(@PathVariable("defectionId") long defectionId) {
		defectionService.deleteDefection(defectionId);
		return "service_templates/service_auto_admin_main_page";
	}

}
