package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.Stock;
import it.sopra.stage.fullmoda.entities.StockPK;

public interface StockRepository extends CrudRepository<Stock, StockPK> {

}
