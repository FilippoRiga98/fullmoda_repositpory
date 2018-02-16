package it.sopra.stage.fullmoda.service;

import java.util.List;

import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.CartEntry;

public interface CartService {
	
	Cart getCartByUser(String email);
	
	List<CartEntry> removeFromCart(String productCode, Long cartId);

	List<CartEntry> removeAllFromCart(Long cartId);

	void save(Cart cart);
}
