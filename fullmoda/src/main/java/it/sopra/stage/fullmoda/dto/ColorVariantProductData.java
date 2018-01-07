package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;
import java.util.List;

public class ColorVariantProductData implements Serializable{

	private static final long serialVersionUID = -1596107255131789067L;

	private String code;
	private ColorData colorData;
	
	private List<SizeVariantProductData> variants;

	public ColorData getColorData() {
		return colorData;
	}

	public void setColorData(ColorData colorData) {
		this.colorData = colorData;
	}

	public List<SizeVariantProductData> getVariants() {
		return variants;
	}

	public void setVariants(List<SizeVariantProductData> variants) {
		this.variants = variants;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ColorVariantProductData [colorData=").append(colorData).append(", variants=[");
		if(variants != null) {
			for(SizeVariantProductData sizeProduct : variants) {
				sb.append("->[").append(sizeProduct).append("]");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public ColorVariantProductData(String code, ColorData colorData, List<SizeVariantProductData> variants) {
		this.code = code;
		this.colorData = colorData;
		this.variants = variants;
	}
	
	
	
}
