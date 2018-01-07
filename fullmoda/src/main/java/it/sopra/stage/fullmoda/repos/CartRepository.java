package it.sopra.stage.fullmoda.repos;

import org.springframework.data.repository.CrudRepository;

import it.sopra.stage.fullmoda.entities.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

	public Cart findByUserEmail(String email);
}
