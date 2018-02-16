package it.sopra.stage.fullmoda.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ForgotPasswordForm implements Serializable {

	private static final long serialVersionUID = 8024629241671545348L;
	
	@Email
	@NotEmpty
	private String email;
}
