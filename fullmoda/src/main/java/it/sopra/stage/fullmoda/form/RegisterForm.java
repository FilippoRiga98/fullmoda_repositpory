package it.sopra.stage.fullmoda.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import it.sopra.stage.fullmoda.constraints.FieldMatch;
import lombok.Data;

@Data
@FieldMatch(first="password", second="passwordConfirmation")
public class RegisterForm {

	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String name;
	@NotEmpty
	private String surname;
	@NotEmpty
	@Size(min = 8, max = 20)
	private String password;
	@NotEmpty
	private String passwordConfirmation;
	
	@AssertTrue
	private boolean privacy;
	
	
	
	
}
