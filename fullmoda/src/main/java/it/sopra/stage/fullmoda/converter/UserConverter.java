package it.sopra.stage.fullmoda.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.model.User;

@Component
public class UserConverter {
	
	@Autowired 
	private PasswordEncoder passwordEncoder;

	public UserData convert(User source) {
		
		UserData target = new UserData();
		target.setId(source.getId());
		target.setEmail(source.getEmail());
		target.setName(source.getName());
		target.setSurname(source.getSurname());
		target.setPassword(source.getPassword());
		target.setBirthDate(source.getBirthDate());
		target.setBirthPlace(source.getBirthPlace());
		target.setCustomerType(source.getCustomerType());
		target.setFiscalCode(source.getFiscalCode());
		target.setPrivacyAgreement(source.isPrivacyAgreement());
		target.setPhoneNumber(source.getPhoneNumber());
		target.setAddress(source.getAddress());
		
		return target;
	}
	
	public User convert(UserData source) {
		
		User target = new User();
		target.setId(source.getId());
		target.setEmail(source.getEmail());
		target.setName(source.getName());
		target.setSurname(source.getSurname());
		target.setPassword(passwordEncoder.encode(source.getPassword()));
		target.setBirthDate(source.getBirthDate());
		target.setBirthPlace(source.getBirthPlace());
		target.setCustomerType(source.getCustomerType());
		target.setFiscalCode(source.getFiscalCode());
		target.setPrivacyAgreement(source.isPrivacyAgreement());
		target.setPhoneNumber(source.getPhoneNumber());
		target.setAddress(source.getAddress());
		
		return target;
	}
}
