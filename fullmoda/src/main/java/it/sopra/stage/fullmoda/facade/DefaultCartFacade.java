package it.sopra.stage.fullmoda.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.CartConverter;
import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.service.CartService;

@Component
public class DefaultCartFacade implements CartFacade{

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartConverter cartConverter;

	@Override
	public CartData getCartByUser(String email) {
		Cart cart = cartService.getCartByUser(email);
		return cartConverter.convert(cart);
	}

	@Override
	public int removeFromCart(String productCode, int quantity) {
		return 0;
	}

	@Override
	public int addToCart(String productCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addToCart(String productCode, int quantity) {
		// TODO Auto-generated method stub
		
	}

}
