package it.sopra.stage.fullmoda.form;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ProductForm implements Serializable{

	private static final long serialVersionUID = -1128349127577363563L;
	
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
