package it.sopra.stage.fullmoda.facade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.UserConverter;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.dto.UserTypeEnum;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.form.RegisterForm;
import it.sopra.stage.fullmoda.model.User;
import it.sopra.stage.fullmoda.service.UserService;

@Component
public class DefaultUserFacade implements UserFacade
{
	@Autowired
	private UserService userService;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	protected AuthenticationManager authenticationManager;

	@Override
	public boolean save(UserData user, boolean encodePassword)
	{
		return userService.save(userConverter.convert(user, encodePassword));
	}

	@Override
	public void updatePassword(String password, String email)
	{
		userService.updatePassword(password, email);		
	}
	
	@Override
	public UserData validateUser(String email, String password) {
		
		User user = userService.validateUser(email, password);
		UserData userData = null;
		if(user != null) {
			userData = userConverter.convert(user);
		}
		return userData;
	}
	
	@Override
	public UserData register(RegisterForm registerForm, UserTypeEnum.USERTYPE userType) throws UserAlreadyRegistered  {
		
		UserData userData = new UserData(registerForm.getName(), registerForm.getSurname(), userType.name(), registerForm.getEmail(), registerForm.getPassword(), registerForm.isPrivacy());
		
		User user = userService.registerUser(userConverter.convert(userData, true));
		
		userData = null;		
		if(user != null) {
			userData = userConverter.convert(user);
		}
		
		return userData;
	}
	
	@Override
	public UserData validateUser(String email)
	{
		User user = userService.validateUser(email);
		UserData userData = null;
		if(user != null) {
			userData = userConverter.convert(user);
		}
		return userData;
	}

	@Override
	public void autoLoginAfterRegisration(String username, String password, HttpServletRequest request)
	{

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
		request.getSession();
		authToken.setDetails(new WebAuthenticationDetails(request));
      
        Authentication authentication = authenticationManager.authenticate(authToken);
     
        SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}
}
