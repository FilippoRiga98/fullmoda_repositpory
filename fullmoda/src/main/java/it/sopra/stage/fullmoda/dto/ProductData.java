package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;
import java.util.List;

import it.sopra.stage.fullmoda.entities.ColorVariantProduct;

public class ProductData implements Serializable {

	private static final long serialVersionUID = -663422750685935211L;
	
	private String code;
	private String description;
	private List<ColorVariantProductData> variants;
	private PriceData price;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ColorVariantProductData> getVariants() {
		return variants;
	}
	public void setVariants(List<ColorVariantProductData> variants) {
		this.variants = variants;
	}
	
	public PriceData getPrice() {
		return price;
	}
	public void setPrice(PriceData price) {
		this.price = price;
	}
	public ProductData(String code, String description, List<ColorVariantProductData> variants) {
		this.code = code;
		this.description = description;
		this.variants = variants;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ProductData ");
		sb.append("[code=").append(code).append("], description=").append(description).append(", variants=[");
		if(variants != null) {
			for(ColorVariantProductData colorVariant : variants) {
				sb.append("->[").append(colorVariant).append("]");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	
}
