package it.sopra.stage.fullmoda.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.sopra.stage.fullmoda.model.User;

@Controller
public class MyAccountController {

	private static final Logger LOG = Logger.getLogger(MyAccountController.class);
	
	@RequestMapping(value="/my-account", method = RequestMethod.GET)
	public String showMyAccountPage(Model model, HttpServletRequest request){
		return "my-account"; 
	} 
}
