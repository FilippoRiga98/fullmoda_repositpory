package it.sopra.stage.fullmoda.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.CartConverter;
import it.sopra.stage.fullmoda.converter.CartEntryConverter;
import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.CartEntryData;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.CartEntry;
import it.sopra.stage.fullmoda.service.CartService;

@Component
public class DefaultCartFacade implements CartFacade{
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartConverter cartConverter;
	
	@Autowired
	private CartEntryConverter entryConverter;

	@Override
	public CartData getCartByUser(String email) {
		Cart cart = cartService.getCartByUser(email);
		return cartConverter.convert(cart);
	}

	@Override
	public List<CartEntryData> removeFromCart(String productCode, Long cartId) {
	    
		List<CartEntry> entries = cartService.removeFromCart(productCode, cartId);
	    List<CartEntryData> entriesData = new ArrayList<CartEntryData>();
		
		for(CartEntry entry : entries) {
			entriesData.add(entryConverter.convert(entry));
		}
		
		return entriesData;
	}

	@Override
	public void addToCart(CartData cartData) {
	    Cart cart = cartConverter.convert(cartData);
		cartService.addToCart(cart);
	}

	@Override
	public List<CartEntryData> addEntryQuantity(CartEntryData entry, int quantity,
			List<CartEntryData> entries) {
		
		int updatedQuantity = (entry.getQuantity()) + quantity;
		entries.forEach(x -> {if(x.getProduct().getCode().equals(entry.getProduct().getCode()))
			x.setQuantity(updatedQuantity);});		
		return entries;
	}

	@Override
	public List<CartEntryData> removeAllFromCart(Long cartId) {
		
		List<CartEntry> entries = cartService.removeAllFromCart(cartId);
		List<CartEntryData> entriesData = new ArrayList<CartEntryData>();
		
		for(CartEntry entry : entries) {
			entriesData.add(entryConverter.convert(entry));
		}
		
		return entriesData;
	}

	@Override
	public void updateEntryQuantity(CartData cartData) {
		Cart cart = cartConverter.convert(cartData);
		cartService.updateQuantity(cart);
	}

}
