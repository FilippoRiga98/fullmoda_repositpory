package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressData implements Serializable{

	private static final long serialVersionUID = 2378278969842883753L;
	
	private Long id;
	private String title;
	private String line1;
	private String line2; 
	private String zipCode;
	private String town;
	private CountryData country;
	
	public AddressData() {
		
	}
	
	public AddressData(String line1, String zipCode, String town, CountryData country) {
		this.line1 = line1;
		this.zipCode = zipCode;
		this.town = town;
		this.country = country;
	}
	
}
