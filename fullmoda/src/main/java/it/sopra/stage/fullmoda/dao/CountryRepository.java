package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.entities.Country;

public interface CountryRepository extends JpaRepository<Country,String> {

}
