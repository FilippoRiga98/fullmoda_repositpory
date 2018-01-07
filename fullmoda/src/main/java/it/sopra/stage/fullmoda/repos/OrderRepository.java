package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
