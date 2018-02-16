package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CountryData implements Serializable{

	private static final long serialVersionUID = 5115652331650077013L;
	
	private String code;
	private String name;

	public CountryData() {
		
	}
	
	public CountryData(String name) {
		this.name = name;
	}
}
