package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CartEntryProductData implements Serializable{
	
	private static final long serialVersionUID = 1306932545819721545L;
	
	private CartEntryData entry;
	private ProductData product;
	private ColorVariantProductData colorVariant;

}
