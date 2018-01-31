package it.sopra.stage.fullmoda.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.facade.AuthFacade;
import it.sopra.stage.fullmoda.form.LoginForm;

@Controller
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	@Autowired
	private AuthFacade loginFacade;

	@Autowired
	private MessageSource messageSource;
 

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(Model model,
			@RequestParam(value = "error", required = false) boolean error,
			@RequestParam(value = "logout", required = false) boolean logout){
		if(SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
				 !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken))
		{
			return "redirect:/products";
		}
		if (error != false) {
			model.addAttribute("error", messageSource.getMessage("login.invalid.credentials", null, LocaleContextHolder.getLocale()));
		}
		if (logout != false) {
			model.addAttribute("msg", messageSource.getMessage("login.logout.performed", null, LocaleContextHolder.getLocale()));
		}
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	//Il controller del LOGIN in post non serve in quanto è integrato in Spring Security
	
	/*@RequestMapping(value="/performlogin", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model, HttpServletRequest request){

		
		if (bindingResult.hasErrors()) {
			LOG.warn(String.format("Validation error on login page, found %s errors", bindingResult.getErrorCount()));
			return "/login?error=true";
		}
		
		return "redirect:/products";
	}*/

	
}
