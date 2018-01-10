package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
