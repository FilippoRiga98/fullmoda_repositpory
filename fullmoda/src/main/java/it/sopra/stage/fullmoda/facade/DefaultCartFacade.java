package it.sopra.stage.fullmoda.facade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.CartConverter;
import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.CartEntryData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.form.ProductForm;
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
	public void addToCart(CartData cartData) {
	    Cart cart = cartConverter.convert(cartData);
		cartService.addToCart(cart);
	}

	@Override
	public List<CartEntryData> updateOrCreateEntry(Optional<CartEntryData> optionalEntry, ProductForm productForm,
			List<CartEntryData> entries, SizeVariantProductData sizeVariant) {
		
		if(optionalEntry.isPresent()) {
			int updatedQuantity = (optionalEntry.get().getQuantity()) + productForm.getQuantity();
			entries.forEach(x -> {if(x.getProduct().getCode().equals(optionalEntry.get().getProduct().getCode()))
				x.setQuantity(updatedQuantity);});
			
		}
		else {
			CartEntryData entry = new CartEntryData();
			entry.setProduct(sizeVariant);
			entry.setQuantity(productForm.getQuantity());
			entries.add(entry);
		}
		
		return entries;
	}

}
