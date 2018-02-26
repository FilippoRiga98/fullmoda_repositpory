package it.sopra.stage.fullmoda.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.AddressConverter;
import it.sopra.stage.fullmoda.converter.CountryConverter;
import it.sopra.stage.fullmoda.dto.AddressData;
import it.sopra.stage.fullmoda.dto.CountryData;
import it.sopra.stage.fullmoda.model.Address;
import it.sopra.stage.fullmoda.model.Country;
import it.sopra.stage.fullmoda.service.AddressService;

@Component
public class DefaultAddressFacade implements AddressFacade {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CountryConverter countryConverter;
	
	@Autowired
	private AddressConverter addressConverter;
	
	@Override
	public List<CountryData> getCountries() {
		
		List<Country> countries = addressService.getCountries();
		List<CountryData> countriesData = new ArrayList<>();
		
		countries.forEach(x -> countriesData.add(countryConverter.convert(x)));
		
		return countriesData;
	}

	@Override
	public AddressData validateAddress(String line1, String zipCode, String town, String countryCode) {
		
		Address address = addressService.validateAddress(line1, zipCode, town, countryCode);
		AddressData addressData = addressConverter.convert(address);
		
		
		return addressData;
	}

}
