package it.sopra.stage.fullmoda.controllers;

import java.util.Locale;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.sopra.stage.fullmoda.dto.PasswordResetTokenData;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.facade.TokenFacade;
import it.sopra.stage.fullmoda.facade.UserFacade;
import it.sopra.stage.fullmoda.form.ResetPasswordForm;

@Controller
public class ResetPasswordController
{
	private static final Logger LOG = Logger.getLogger(ResetPasswordController.class);
	
	@Autowired
	private UserFacade userFacade;
	@Autowired 
	private TokenFacade resetTokenFacade;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping("/reset-password")
	public String showResetPasswordForm(@RequestParam(value="token", required = false) String token, Model model) {
		
		Locale currentLocale = LocaleContextHolder.getLocale();
		PasswordResetTokenData resetTokenData = resetTokenFacade.findByToken(token);
		if(resetTokenData == null) {
			model.addAttribute("error", messageSource.getMessage("reset.password.inavlid.token",null, currentLocale));
		} else if(resetTokenData.isExpired()) {
			model.addAttribute("error", messageSource.getMessage("reset.password.expired.token",null, currentLocale));
		} else {
			model.addAttribute("token", resetTokenData.getToken());
		}
		
		model.addAttribute("resetPasswordForm", new ResetPasswordForm());
		
		return "reset-password";
	}
	
	@RequestMapping(value = "/reset-password", method = RequestMethod.POST)
	@Transactional
	public String doResetPassword(@ModelAttribute("resetPasswordForm") @Valid ResetPasswordForm resetPasswordForm,
			BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			 LOG.warn(String.format("Validation error on reset-password page, found %s errors", bindingResult.getErrorCount()));
			 model.addAttribute("token", resetPasswordForm.getToken());
          return "reset-password";
		}
		
		PasswordResetTokenData tokenReset = resetTokenFacade.findByToken(resetPasswordForm.getToken());
	
      UserData user = tokenReset.getUser();     
      user.setPassword(passwordEncoder.encode(resetPasswordForm.getPassword()));

   	userFacade.updatePassword(user.getPassword(), user.getEmail());  
   	resetTokenFacade.delete(tokenReset);
  
      return "redirect:/login?resetSuccess";
	}
}
