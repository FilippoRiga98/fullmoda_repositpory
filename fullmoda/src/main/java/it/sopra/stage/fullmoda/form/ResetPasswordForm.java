package it.sopra.stage.fullmoda.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import it.sopra.stage.fullmoda.constraints.FieldMatch;
import lombok.Data;

@Data
@FieldMatch(first = "password", second = "confirmPassword")
public class ResetPasswordForm
{
	@NotBlank
	@Size(min = 8, max = 20)
   private String password;
	@NotBlank
   private String confirmPassword;
   @NotEmpty
   private String token;
}
