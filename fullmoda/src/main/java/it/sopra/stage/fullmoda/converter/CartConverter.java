package it.sopra.stage.fullmoda.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.CartEntryData;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.CartEntry;
import it.sopra.stage.fullmoda.model.User;
import it.sopra.stage.fullmoda.model.Website;

@Component
public class CartConverter {

	@Autowired
	private CartEntryConverter cartEntryConverter;
	
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private WebsiteConverter websiteConverter;
	
	public CartData convert(Cart cart) {
		Long cartId = cart.getId();
		User user = cart.getUser(); 
		Website website = cart.getWebsite();
		List<CartEntry> entries = cart.getCartEntries();
		List<CartEntryData> entriesData = new ArrayList<>();
		for(CartEntry entry : entries) {
			entriesData.add(cartEntryConverter.convert(entry));
		}
		return new CartData(cartId, entriesData, userConverter.convert(user), websiteConverter.convert(website));
	}
	
	public Cart convert(CartData source) {
		Cart target = new Cart();
		target.setId(source.getId());
		target.setUser(userConverter.convert(source.getUser(), false));
		target.setWebsite(websiteConverter.convert(source.getWebsite()));
		List<CartEntryData> entriesData = source.getEntries();
		if(entriesData != null) {
			entriesData.forEach(x -> target.addCartEntry(cartEntryConverter.convert(x)));
			target.getCartEntries().forEach(x -> x.setCart(target));
		}
		else {
			List<CartEntry> entries = new ArrayList<CartEntry>();
			target.setCartEntries(entries);
		}
		return target;
	}
}
