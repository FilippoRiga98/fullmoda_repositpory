package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.entities.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String> {

}
