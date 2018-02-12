package it.sopra.stage.fullmoda.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.CartEntryData;
import it.sopra.stage.fullmoda.dto.CartEntryProductData;
import it.sopra.stage.fullmoda.dto.ColorVariantProductData;
import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.facade.CartFacade;
import it.sopra.stage.fullmoda.facade.ProductFacade;
import it.sopra.stage.fullmoda.form.ProductForm;

@Controller
public class CartController {

	private final static Logger LOG = Logger.getLogger(CartController.class);
	
	@Autowired
	private CartFacade cartFacade;
	
	@Autowired
	private ProductFacade productFacade;
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(@ModelAttribute("productForm") final ProductForm productForm,
			HttpServletRequest request) {
		
		CartData cart = null;
		cart = (CartData) request.getSession(false).getAttribute("cart");
		List<CartEntryData> entries = null;
		if(cart != null) {
			entries = cart.getEntries();
		}
		else {
			return "redirect:/p-" + productForm.getBaseProductCode();
		}
		ProductData product = null;
		try {	
			product = productFacade.findProduct(productForm.getBaseProductCode());
		} catch(Exception e) {	
			LOG.error("Non riesco a trovare il prodotto nel DB, assicurarsi che sia un prodotto valido o che esista");
		}
		
		Optional<SizeVariantProductData> sizeVariant = null;
		if(product != null) {		
			sizeVariant = productFacade.searchSizeVariant(product, productForm);
		} 
		else {	
			return "redirect:/p-" + productForm.getBaseProductCode();		
		}
	
		final Optional<SizeVariantProductData> optionalVariant = sizeVariant;
		try {
			if(optionalVariant.isPresent()) {
				Optional<CartEntryData> optionalEntry = entries.stream().filter(x -> x.getProduct().getCode()
						.equals(optionalVariant.get().getCode())).findFirst();
				entries = cartFacade.updateOrCreateEntry(optionalEntry, productForm, entries, sizeVariant.get());
				
				cart.setEntries(entries);
				cartFacade.addToCart(cart);
				
				request.getSession(false).setAttribute("cart", cart);
			}
		} catch(Exception e) {
			LOG.error("Non riesco ad aggiungere la entry al carrello per il carrello di id: " + cart.getId() + e.getMessage());
		}
		
		
		return "redirect:/p-" + productForm.getBaseProductCode();
	}
	
	@RequestMapping("/removeProduct")
	public int removeProduct(final String productCode, final int quantity) {
		return cartFacade.removeFromCart(productCode, quantity);
	}
	
	@RequestMapping("/cart")
	public String getCart(HttpServletRequest request, Model model) {
		
		CartData cart = (CartData) request.getSession().getAttribute("cart");
		List<CartEntryProductData> entriesWithProduct = new ArrayList<>();
		List<CartEntryData> entries = cart.getEntries();
		List<ProductData> products = productFacade.getProductList("EUR");
		for(CartEntryData entry : entries) {
			
			CartEntryProductData entryWithProduct = new CartEntryProductData();
			entryWithProduct.setEntry(entry);
			
			ProductData product = new ProductData();
			for(ProductData x : products) {
				
				List<ColorVariantProductData> colorVariants = x.getVariants();
				 
				for(ColorVariantProductData y : colorVariants) {
					
					List<SizeVariantProductData> sizeVariants = y.getVariants();
					
					for(SizeVariantProductData z : sizeVariants) {
						if(entry.getProduct().getCode().equals(z.getCode())) {
							product = x;
						}
					}
				}
			}
			
			entryWithProduct.setProduct(product);
			
			LOG.info("Prodotto: " + product.getShortDescription());
			
			entriesWithProduct.add(entryWithProduct);
		}
		
		model.addAttribute("entries", entriesWithProduct);
		
		return "cart";
	}
	
	
}
