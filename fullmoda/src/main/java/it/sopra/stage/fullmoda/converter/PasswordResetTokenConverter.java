package it.sopra.stage.fullmoda.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.PasswordResetTokenData;
import it.sopra.stage.fullmoda.model.PasswordResetToken;

@Component
public class PasswordResetTokenConverter
{
	@Autowired
	private UserConverter userConverter;
	
	public PasswordResetTokenData convert(PasswordResetToken source) {
		PasswordResetTokenData target = new PasswordResetTokenData();
		if(source != null) {
   		target.setId(source.getId());
   		target.setToken(source.getToken());
   		target.setUser(userConverter.convert(source.getUser()));
   		target.setExpiryDate(source.getExpiryDate());
		}
		
		return target;
	}
	
	public PasswordResetToken convert(PasswordResetTokenData source) {
		PasswordResetToken target = new PasswordResetToken();
		if(source != null) {
   		target.setId(source.getId());
   		target.setToken(source.getToken());
   		target.setUser(userConverter.convert(source.getUser()));
   		target.setExpiryDate(source.getExpiryDate());
		}
		
		return target;
	}
}
