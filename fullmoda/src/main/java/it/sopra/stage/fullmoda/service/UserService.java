package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.model.User;

public interface UserService
{
	boolean save(User user);
	void updatePassword(String password, String email);
	User validateUser(String email);
	User validateUser(String email, String password);
	User registerUser(User user) throws UserAlreadyRegistered;
}
