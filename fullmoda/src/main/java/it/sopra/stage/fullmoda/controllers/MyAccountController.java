package it.sopra.stage.fullmoda.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.sopra.stage.fullmoda.dto.AddressData;
import it.sopra.stage.fullmoda.dto.CountryData;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.facade.AddressFacade;
import it.sopra.stage.fullmoda.facade.UserFacade;
import it.sopra.stage.fullmoda.form.UpdateContactInfoForm;
import it.sopra.stage.fullmoda.form.UpdatePasswordForm;

@Controller
public class MyAccountController {

	private final static Logger LOG = Logger.getLogger(MyAccountController.class);
	
	@Autowired
	private UserFacade userFacade;
	
	@Autowired
	private AddressFacade addressFacade;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat.setLenient(false);
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value="/my-account", method = RequestMethod.GET)
	public String showMyAccountPage(Model model, HttpServletRequest request){
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		UserData user = userFacade.validateUser(email);
		
		List<CountryData> countries = addressFacade.getCountries();		
		model.addAttribute("countries", countries);
		model.addAttribute("user", user);
		model.addAttribute("contactForm", new UpdateContactInfoForm());
		model.addAttribute("passwordForm", new UpdatePasswordForm());
		
		return "my-account"; 
	} 
	
	@RequestMapping(value="/updateContactInfo", method = RequestMethod.POST)
	public String updateContactInfo(@ModelAttribute("contactForm") @Valid UpdateContactInfoForm contactForm, 
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		UserData user = null;
		try {
			
			user = userFacade.validateUser(email);			
		} catch(Exception e) {
			
			LOG.warn("User not found, you are logging out");
			try {
				request.logout();
			} catch (ServletException se) {
				LOG.fatal("Servlet error");
			}
		}
		
		if(bindingResult.hasErrors()) {
			LOG.warn(String.format("Validation error on update contact info section, found %s errors", bindingResult.getErrorCount()));
			model.addAttribute("passwordForm", new UpdatePasswordForm());
			model.addAttribute("countries", addressFacade.getCountries());
			model.addAttribute("user", user);
			return "my-account";
		}
		
		CountryData country = contactForm.getCountry();
		String line1 = contactForm.getLine1().toLowerCase();
		String zipCode = contactForm.getZipcode();
		String town = contactForm.getCity().toLowerCase();
		
		AddressData address = null;
		try {
			address = addressFacade.validateAddress(line1, zipCode, town, country.getCode());
		} catch(Exception e) {
			LOG.warn(String.format("Address doesn't exists:%s", contactForm.toString()));
		}
		
		if(address == null) {
			address = new AddressData(line1, zipCode, town, country);
		}
		
		user.setAddress(address);	
		user.setName(contactForm.getName());
		user.setSurname(contactForm.getSurname());
		user.setFiscalCode(contactForm.getFiscalCode());
		
		user.setBirthDate(contactForm.getBirthDate());
		user.setBirthPlace(contactForm.getBirthPlace());
		user.setPhoneNumber(contactForm.getPhoneNumber());
		
		try {
			
			userFacade.save(user, false);
		} catch (Exception e) {
			
			LOG.warn("Something went wrong, please retry");
		}
		
		return "redirect:/my-account";
	}
	
	@RequestMapping(value = "/updateLoginInfo", method = RequestMethod.POST) 
	@Transactional
	public String updateLoginInfo(@ModelAttribute("passwordForm") @Valid UpdatePasswordForm passwordForm, 
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		UserData user = null;
		try {
			
			user = userFacade.validateUser(email);			
		} catch(Exception e) {
			
			LOG.warn("User not found, you are logging out");
			try {
				request.logout();
			} catch (ServletException se) {
				LOG.fatal("Servlet error");
			}
		}
		
		if(bindingResult.hasErrors()) {
			LOG.warn(String.format("Validation error on update login info section, found %s errors", bindingResult.getErrorCount()));
			model.addAttribute("contactForm", new UpdateContactInfoForm());
			model.addAttribute("countries", addressFacade.getCountries());
			model.addAttribute("user", user);
			return "my-account";
		}
		
		String password = passwordEncoder.encode(passwordForm.getPassword());		
		userFacade.updatePassword(password, email);
		
		return "redirect:/my-account";
	}
}
