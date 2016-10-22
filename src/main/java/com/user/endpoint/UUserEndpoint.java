package com.user.endpoint;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan
@RequestMapping(value ="/serviceauto/user")
public class UUserEndpoint {


	@RequestMapping(value ="/main",method = RequestMethod.GET)
	public String directToUserMainPage(){
		return "user_templates/user_redirectToUserMainPage";
	}
}
