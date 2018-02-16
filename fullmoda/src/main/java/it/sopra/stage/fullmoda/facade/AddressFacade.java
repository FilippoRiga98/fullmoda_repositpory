package it.sopra.stage.fullmoda.facade;

import java.util.List;

import it.sopra.stage.fullmoda.dto.AddressData;
import it.sopra.stage.fullmoda.dto.CountryData;

public interface AddressFacade {

	List<CountryData> getCountries();
	
	AddressData validateAddress(String line1, String zipCode, String town, String countryCode);
}
