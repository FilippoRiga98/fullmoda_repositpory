package it.sopra.stage.fullmoda.controllers;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

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

import it.sopra.stage.fullmoda.dto.MailData;
import it.sopra.stage.fullmoda.dto.PasswordResetTokenData;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.facade.TokenFacade;
import it.sopra.stage.fullmoda.facade.UserFacade;
import it.sopra.stage.fullmoda.form.ForgotPasswordForm;

@Controller
public class ForgotPasswordController
{
	private static final Logger LOG = Logger.getLogger(ForgotPasswordController.class);
	
	@Autowired 
	private MessageSource messageSource;
	@Autowired
	private TokenFacade passwordResetTokenFacade;
	@Autowired
	private UserFacade userFacade;
	//@Autowired
	//private EmailService emailService;
	
	@RequestMapping("/forgot-password")
	public String showForgotPasswordPage(Model model) {
		if(SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
				 !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			LOG.info("User is already logged, log out needed. You are been redirecting to the home page");
			return "redirect:/home";
		}
		
		model.addAttribute("forgotPasswordForm", new ForgotPasswordForm());
		return "forgot-password";
	}
	
	@RequestMapping(value = "/forgot-password", method = RequestMethod.POST)
	public String doForgotPassword(@ModelAttribute("forgotPasswordForm") @Valid ForgotPasswordForm forgotPasswordForm, BindingResult bindingResult, 
			HttpServletRequest request, Model model) {
		
		if(bindingResult.hasErrors()) {
			LOG.warn(String.format("Validation error on forgot-password page, found %s errors", bindingResult.getErrorCount()));
			return "forgot-password";
		}
		
		UserData userData = userFacade.validateUser(forgotPasswordForm.getEmail());
		
		
		if(userData == null) {
			LOG.warn(String.format("User not found for parameters: email [%s]", forgotPasswordForm.getEmail()));
			Locale currentLocale = LocaleContextHolder.getLocale();
			bindingResult.addError(new ObjectError("globalerrors", messageSource.getMessage("forgot.password.invalid.email",
					null, currentLocale)));
			return "forgot-password";

		}
		
		PasswordResetTokenData token = new PasswordResetTokenData();
      token.setToken(UUID.randomUUID().toString());
      token.setUser(userData);
      token.setExpiryDate(60 * 24);
   
      passwordResetTokenFacade.save(token);
      
      MailData mail = new MailData();
      mail.setFrom("no-reply@fullmoda.it");
      mail.setTo(userData.getEmail());
      mail.setSubject("Password reset request");
      
      Map<String, Object> emailModel = new HashMap<>();
      emailModel.put("token", token);
      emailModel.put("user", userData);
      emailModel.put("signature", "https://fullmoda.it");
      emailModel.put("resetUrl", "reset-password?token=" + token.getToken());
      mail.setModel(emailModel);
      
      model.addAttribute("mail", mail);
      
      return "mock-reset-email";
      
      //emailService.sendEmail(mail);
		
		//return "redirect:/forgot-password?success";
	}
	
}
