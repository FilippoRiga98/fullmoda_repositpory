package it.sopra.stage.fullmoda.form;

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
	private int quantity;
	
}
