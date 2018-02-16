package it.sopra.stage.fullmoda.facade;

import java.util.List;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.CartEntryData;

public interface CartFacade {
	
	CartData getCartByUser(String email);
	
	List<CartEntryData> removeFromCart(String productCode, Long cartId);
	
	List<CartEntryData> removeAllFromCart(Long cartId);

	List<CartEntryData> addEntryQuantity(CartEntryData entry, int quantity, List<CartEntryData> entries);

	void save(CartData cart);	
}
