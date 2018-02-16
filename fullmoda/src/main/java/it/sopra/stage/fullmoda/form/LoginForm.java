package it.sopra.stage.fullmoda.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginForm implements Serializable {

	private static final long serialVersionUID = 1526016238972787882L;

	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String password;
}
