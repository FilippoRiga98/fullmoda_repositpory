package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

public class SizeData implements Serializable{

	private static final long serialVersionUID = 7318574783866190102L;
	
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public SizeData(String code) {
		this.code = code;
	}
	
	
}
