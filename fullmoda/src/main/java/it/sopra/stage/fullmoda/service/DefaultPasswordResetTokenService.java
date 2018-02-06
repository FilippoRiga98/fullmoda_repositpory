package it.sopra.stage.fullmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sopra.stage.fullmoda.dao.PasswordResetTokenRepository;
import it.sopra.stage.fullmoda.model.PasswordResetToken;

@Service("passwordResetTokenService")
public class DefaultPasswordResetTokenService implements TokenService
{
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public void save(PasswordResetToken token)
	{
		passwordResetTokenRepository.save(token);		
	}

	@Override
	public PasswordResetToken findByToken(String token)
	{
		PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
		return passwordResetToken;
	}

	@Override
	public void delete(PasswordResetToken token)
	{
		passwordResetTokenRepository.delete(token);
	}
}
