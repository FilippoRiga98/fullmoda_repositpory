package it.sopra.stage.fullmoda.facade;

import javax.servlet.http.HttpServletRequest;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.dto.UserTypeEnum.USERTYPE;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.form.RegisterForm;

public interface UserFacade
{
	public boolean save(UserData user);
	
	void updatePassword(String password, String email);

	UserData validateUser(String email, String password);

	UserData register(RegisterForm registerForm, USERTYPE userType) throws UserAlreadyRegistered;

	UserData validateUser(String email);

	void autoLoginAfterRegisration(String username, String password, HttpServletRequest request);
}
