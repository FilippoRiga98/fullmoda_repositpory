package it.sopra.stage.fullmoda.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ForgotPasswordForm
{
	@Email
	@NotEmpty
	private String email;
}
