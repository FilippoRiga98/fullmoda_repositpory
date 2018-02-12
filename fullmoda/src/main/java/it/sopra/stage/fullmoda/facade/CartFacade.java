package it.sopra.stage.fullmoda.facade;

import java.util.List;
import java.util.Optional;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.CartEntryData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.form.ProductForm;

public interface CartFacade {

	int addToCart(String productCode);
	
	void addToCart(CartData cart);
	
	CartData getCartByUser(String email);
	
	int removeFromCart(String productCode, int quantity);

	List<CartEntryData> updateOrCreateEntry(Optional<CartEntryData> optionalEntry, ProductForm productForm,
			List<CartEntryData> entries, SizeVariantProductData sizeVariant);
	
}
