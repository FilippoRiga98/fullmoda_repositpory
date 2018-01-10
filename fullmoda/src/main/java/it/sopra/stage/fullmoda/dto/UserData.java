package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserData implements Serializable{

	private static final long serialVersionUID = -3865741928764031868L;

	private String name;
	private String surname;
	private String username;
	private String email;
	
	public UserData() {
		
	}
	
	public UserData(String name, String surname, String username, String email) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserData [name=" + name + ", surname=" + surname + ", username=" + username + ", email=" + email + "]";
	}
	
}
