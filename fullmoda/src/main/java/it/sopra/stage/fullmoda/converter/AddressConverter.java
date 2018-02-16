package it.sopra.stage.fullmoda.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.AddressData;
import it.sopra.stage.fullmoda.model.Address;

@Component
public class AddressConverter {

	@Autowired
	private CountryConverter countryConverter;
	
	public AddressData convert(Address source) {
		
		AddressData target = new AddressData();
		target.setId(source.getId());
		target.setTitle(source.getTitle());
		target.setLine1(source.getLine1());
		target.setLine2(source.getLine2());
		target.setZipCode(source.getZipCode());
		target.setTown(source.getTown());
		target.setCountry(countryConverter.convert(source.getCountry()));
		
		return target;
	}
	
	public Address convert(AddressData source) {
		
		Address target = new Address();
		target.setId(source.getId());
		target.setTitle(source.getTitle());
		target.setLine1(source.getLine1());
		target.setLine2(source.getLine2());
		target.setZipCode(source.getZipCode());
		target.setTown(source.getTown());
		target.setCountry(countryConverter.convert(source.getCountry()));
		
		return target;
	}
}
