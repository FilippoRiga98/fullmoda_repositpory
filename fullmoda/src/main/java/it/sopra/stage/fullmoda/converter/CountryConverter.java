package it.sopra.stage.fullmoda.converter;

import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.CountryData;
import it.sopra.stage.fullmoda.model.Country;

@Component
public class CountryConverter {

	public CountryData convert(Country source) {
		
		CountryData target = new CountryData();
		target.setCode(source.getCode());
		target.setName(source.getName());
		
		return target;
	}
	
	public Country convert(CountryData source) {
		
		Country target = new Country();
		target.setCode(source.getCode());
		target.setName(source.getName());
		
		return target;
	}
}
