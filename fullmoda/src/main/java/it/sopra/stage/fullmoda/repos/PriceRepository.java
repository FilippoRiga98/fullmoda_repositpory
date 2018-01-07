package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.BaseProduct;
import it.sopra.stage.fullmoda.entities.Currency;
import it.sopra.stage.fullmoda.entities.Price;
import it.sopra.stage.fullmoda.entities.PricePK;

public interface PriceRepository extends CrudRepository<Price, PricePK> {

	public Price findByBaseProductCodeAndCurrencyCode(String code, String currency);
}
