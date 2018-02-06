package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;
import java.util.Date;

import it.sopra.stage.fullmoda.model.Address;
import lombok.Data;

@Data
public class UserData implements Serializable{

	private static final long serialVersionUID = -3865741928764031868L;

   private Long id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String customerType;
	private String phoneNumber;
	private Date birthDate;
	private String birthPlace;
	private boolean privacyAgreement;
	private String fiscalCode;
	private Address address;
	
	public UserData() {
		
	}
	
	public UserData(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	public UserData(String name, String surname, String customerType, String email, String password, boolean privacyAgreement) {
		this.name = name;
		this.surname = surname;
		this.customerType = customerType;
		this.email = email;
		this.password = password;
		this.privacyAgreement = privacyAgreement;
	}
	
	@Override
	public String toString() {
		return "UserData [id=" + id + ",name=" + name + ", surname=" + surname + ", email=" + email + ",password=" + password +"]";
	}
	
}
