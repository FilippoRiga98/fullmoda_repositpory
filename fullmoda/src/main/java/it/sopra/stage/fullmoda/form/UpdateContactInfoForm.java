package it.sopra.stage.fullmoda.form;


import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import it.sopra.stage.fullmoda.dto.CountryData;
import lombok.Data;

@Data
public class UpdateContactInfoForm implements Serializable{

	private static final long serialVersionUID = -1333782525286268610L;
	
	@NotBlank
	private String name;
	@NotBlank
	private String surname;
	@NotBlank
	@Size(min = 10, max = 10)
	private String phoneNumber;
	//@NotBlank da implementare
	private String title;
	@NotBlank
	private String line1;
	//@NotBlank da implementare
	private String line2;	
	@NotBlank
	private String city;
	@NotBlank
	@Size(min = 5, max = 5)
	private String zipcode;
	@NotNull
	private Date birthDate;
	@NotBlank
	private String birthPlace;
	@NotBlank
	@Size(min = 16, max = 16)
	private String fiscalCode;	

	private CountryData country;
	
	@Override
	public String toString() {
		
		String string = "ContactInfo - Address: [line1=" + line1 + ",line2=" + line2 +",city=" + city + ", zipCode=" + zipcode +
				", country=" + country.getName() + "]" ;
		return string;
	}
}
