package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.entities.Stock;
import it.sopra.stage.fullmoda.entities.StockPK;

public interface StockRepository extends JpaRepository<Stock, StockPK> {

}
