package it.sopra.stage.fullmoda.converter;

import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.entities.User;

@Component
public class UserConverter {

	public UserData convert(User user) {
		UserData userData = new UserData(user.getName(), user.getSurname(), user.getUsername(), user.getEmail());
		return userData;
	}
}
