package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.model.PasswordResetToken;

public interface TokenService
{
	void save(PasswordResetToken token);
	
	PasswordResetToken findByToken(String token);
	
	void delete(PasswordResetToken token);
}
