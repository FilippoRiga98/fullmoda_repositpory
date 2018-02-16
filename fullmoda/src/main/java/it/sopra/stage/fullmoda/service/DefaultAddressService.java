package it.sopra.stage.fullmoda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sopra.stage.fullmoda.dao.AddressRepository;
import it.sopra.stage.fullmoda.dao.CountryRepository;
import it.sopra.stage.fullmoda.model.Address;
import it.sopra.stage.fullmoda.model.Country;

@Service
public class DefaultAddressService implements AddressService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public List<Country> getCountries() {
		
		return countryRepository.findAll();
	}

	@Override
	public Address validateAddress(String line1, String zipCode, String town, String countryCode) {
		
		Address address = addressRepository.findByLine1AndZipCodeAndTownAndCountryCode(line1, zipCode, town, countryCode);		
		return address;
	}

}
