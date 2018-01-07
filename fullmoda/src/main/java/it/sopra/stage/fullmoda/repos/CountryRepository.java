package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.Country;

public interface CountryRepository extends CrudRepository<Country,String> {

}
