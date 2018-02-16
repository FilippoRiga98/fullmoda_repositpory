package it.sopra.stage.fullmoda.form;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import it.sopra.stage.fullmoda.constraints.FieldMatch;
import lombok.Data;

@Data
@FieldMatch(first = "password", second = "confirmPassword")
public class UpdatePasswordForm implements Serializable{

	private static final long serialVersionUID = 2320433297565626999L;
	
	private String email;
	@NotBlank
	@Size(min = 8, max = 20)
	private String password;
	@NotBlank
	private String confirmPassword;
}
