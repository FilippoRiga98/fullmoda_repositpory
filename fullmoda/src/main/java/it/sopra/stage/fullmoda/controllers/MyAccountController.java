package it.sopra.stage.fullmoda.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyAccountController {

	
	@RequestMapping(value="/my-account", method = RequestMethod.GET)
	public String showMyAccountPage(Model model, HttpServletRequest request){
		return "my-account"; 
	} 
}
