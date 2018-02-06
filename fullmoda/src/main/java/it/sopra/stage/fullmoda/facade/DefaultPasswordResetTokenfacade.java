package it.sopra.stage.fullmoda.facade;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.PasswordResetTokenConverter;
import it.sopra.stage.fullmoda.dto.PasswordResetTokenData;
import it.sopra.stage.fullmoda.service.TokenService;


@Component
public class DefaultPasswordResetTokenfacade implements TokenFacade
{
	private static final Logger LOG = Logger.getLogger(DefaultPasswordResetTokenfacade.class);
	
	@Autowired
	private TokenService passwordResetTokenService;
	@Autowired
	private PasswordResetTokenConverter passwordResetTokenConverter;
	
	@Override
	public void save(PasswordResetTokenData token)
	{
		passwordResetTokenService.save(passwordResetTokenConverter.convert(token));			
	}

	@Override
	public PasswordResetTokenData findByToken(String token)
	{
		PasswordResetTokenData tokenData = new PasswordResetTokenData();
		tokenData = passwordResetTokenConverter.convert(passwordResetTokenService.findByToken(token));
		return tokenData;
	}

	@Override
	public void delete(PasswordResetTokenData token)
	{
		passwordResetTokenService.delete(passwordResetTokenConverter.convert(token));		
	}

}
