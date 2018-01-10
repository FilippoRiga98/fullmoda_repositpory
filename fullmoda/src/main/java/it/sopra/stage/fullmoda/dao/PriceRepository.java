package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.entities.Price;
import it.sopra.stage.fullmoda.entities.PricePK;

public interface PriceRepository extends JpaRepository<Price, PricePK> {

	public Price findByBaseProductCodeAndCurrencyCode(String code, String currency);
}
