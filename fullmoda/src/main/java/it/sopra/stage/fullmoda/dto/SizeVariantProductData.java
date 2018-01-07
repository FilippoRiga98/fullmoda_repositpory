package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

public class SizeVariantProductData implements Serializable{

	private static final long serialVersionUID = -299235303386525891L;
	
	private String code;
	private SizeData size;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SizeData getSize() {
		return size;
	}

	public void setSize(SizeData size) {
		this.size = size;
	}
	
	public SizeVariantProductData(String code, SizeData size) {
		this.code = code;
		this.size = size;
	}

	@Override
	public String toString() {
		return "SizeVariantProductData [code=" + code + ", size=" + size + "]";
	}

	
	
	
}
