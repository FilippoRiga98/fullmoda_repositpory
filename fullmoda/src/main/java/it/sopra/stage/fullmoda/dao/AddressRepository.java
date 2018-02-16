package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

	Address findByLine1AndZipCodeAndTownAndCountryCode(String line1, String zipCode, String town, String countryCode);
}
