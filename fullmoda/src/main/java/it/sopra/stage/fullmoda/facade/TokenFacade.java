package it.sopra.stage.fullmoda.facade;

import it.sopra.stage.fullmoda.dto.PasswordResetTokenData;

public interface TokenFacade
{
	void save(PasswordResetTokenData token);
	
	PasswordResetTokenData findByToken(String token);
	
	void delete(PasswordResetTokenData token);
}
