package it.sopra.stage.fullmoda.service;

import java.util.List;

import it.sopra.stage.fullmoda.model.Address;
import it.sopra.stage.fullmoda.model.Country;

public interface AddressService {

	List<Country> getCountries();

	Address validateAddress(String line1, String zipCode, String town, String countryCode);
}
