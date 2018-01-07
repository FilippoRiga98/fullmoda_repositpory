package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, String> {

}
