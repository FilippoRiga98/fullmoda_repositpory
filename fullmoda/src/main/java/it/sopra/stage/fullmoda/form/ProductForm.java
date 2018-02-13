package it.sopra.stage.fullmoda.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductForm {

	@NotNull
	private String baseProductCode;
	@NotNull
	private String color;
	@NotNull
	private String size;
	@NotNull
	@Min(1)
	private int quantity;
	
}
