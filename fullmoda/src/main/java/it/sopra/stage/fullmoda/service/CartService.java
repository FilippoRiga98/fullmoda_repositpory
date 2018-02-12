package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.model.Cart;

public interface CartService {

	int addToCart(String productCode);
	
	void addToCart(Cart cart);
	
	Cart getCartByUser(String email);
	
	int removeFromCart(String productCode, int quantity);
}
