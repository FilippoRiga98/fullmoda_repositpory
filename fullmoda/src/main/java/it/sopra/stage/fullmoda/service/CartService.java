package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.entities.Cart;

public interface CartService {

	int addToCart(String productCode);
	
	Cart getCartByUser(String email);
	
	int removeFromCart(String productCode, int quantity);
}
