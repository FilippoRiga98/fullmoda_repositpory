package it.sopra.stage.fullmoda.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addToCart(@ModelAttribute("productForm") @Valid final ProductForm productForm,
			HttpServletRequest request, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			LOG.error("Scegliere almeno un colore e una taglia e scgliere una quantita' superiore a 0");
			return "redirect:/p-" + productForm.getBaseProductCode();
		}
		
		CartData cart = null;
		cart = (CartData) request.getSession().getAttribute("cart");
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
	
		if(optionalVariant.isPresent()) {
			
			if(entries != null) {
				Optional<CartEntryData> optionalEntry = entries.stream().filter(x -> x.getProduct().getCode()
						.equals(optionalVariant.get().getCode())).findFirst();
				
				if(optionalEntry.isPresent()) {
					entries = cartFacade.addEntryQuantity(optionalEntry.get(), productForm.getQuantity(), entries);
				} 
				else {
					CartEntryData entry = new CartEntryData();
					entry.setProduct(sizeVariant.get());
					entry.setQuantity(productForm.getQuantity());
					entries.add(entry);
				}
			}
			else {
				entries = new ArrayList<CartEntryData>();
				CartEntryData entry = new CartEntryData();
				entry.setProduct(sizeVariant.get());
				entry.setQuantity(productForm.getQuantity());
				entries.add(entry);
			}
			cart.setEntries(entries);
			
		}
		
		request.getSession().setAttribute("cart", cart);
		
		try {
			cartFacade.save(cart);
		}			
	    catch(Exception e) {
			LOG.warn("Non riesco ad aggiungere la entry al carrello per il carrello di id: " + cart.getId());
		}
		
		
		return "redirect:/cart";
	}
	
	@RequestMapping("/removeFromCart-{code}")
	public String removeFromCart(@PathVariable("code") String code, HttpServletRequest request) {
		
		CartData cart = null;
		cart = (CartData) request.getSession().getAttribute("cart");
		if(cart != null) {
			
			List<CartEntryData> entries = cart.getEntries();
			Optional<CartEntryData> entryToRemove = entries.stream().filter(x -> x.getProduct().getCode().equals(code)).findFirst();
			
			if(entryToRemove.isPresent()) {
				try {
					cartFacade.removeFromCart(entryToRemove.get().getProduct().getCode(), cart.getId());
				} catch(Exception e) {
					LOG.error("Errore nella rimozione del prodotta da DB");
				}
				
				entries.removeIf(x -> x.getProduct().getCode().equals(entryToRemove.get().getProduct().getCode()));
				cart.setEntries(entries);
			}
			
			request.getSession().setAttribute("cart", cart);
		}
		
		return "redirect:/cart";
	}
	
	@RequestMapping("/cart")
	public String getCart(HttpServletRequest request, Model model) {
		
		CartData cart = (CartData) request.getSession().getAttribute("cart");
		List<CartEntryProductData> entriesWithProduct = new ArrayList<>();
		List<CartEntryData> entries = null;
		if(cart != null) {
			entries = cart.getEntries();
		}
		List<ProductData> products = productFacade.getProductList("EUR");
		if(entries != null) {
			for(CartEntryData entry : entries) {
				
				CartEntryProductData entryWithProduct = new CartEntryProductData();
				entryWithProduct.setEntry(entry);
				
				ProductData product = new ProductData();
				ColorVariantProductData colVariant = new ColorVariantProductData();
				for(ProductData x : products) {
					
					List<ColorVariantProductData> colorVariants = x.getVariants();
					
					for(ColorVariantProductData y : colorVariants) {
						
						List<SizeVariantProductData> sizeVariants = y.getVariants();
						
						for(SizeVariantProductData z : sizeVariants) {
							if(entry.getProduct().getCode().equals(z.getCode())) {
								product = x;
								colVariant = y;
								LOG.info("Color variant: " + colVariant.getColorData().getCode());
							}
						}
						
					}
					
				}
				entryWithProduct.setColorVariant(colVariant);
				entryWithProduct.setProduct(product);
				
				LOG.info("Prodotto: " + product.getShortDescription());
				
				entriesWithProduct.add(entryWithProduct);
			}
		}
		
		model.addAttribute("entries", entriesWithProduct);
		
		return "cart";
	}
	
	@RequestMapping("/removeAllFromCart")
	public String removeAllFromCart(HttpServletRequest request) {
		
		CartData cart = null;
		cart = (CartData) request.getSession().getAttribute("cart");
		if(cart != null) {
			try {
				 cartFacade.removeAllFromCart(cart.getId());
			} catch(Exception e) {
				LOG.error("Errore nella rimozione di tutte le entry dal carrello di id: " + cart.getId());
			}
			
			List<CartEntryData> entries = cart.getEntries();
			if(entries != null) {
				entries.clear();
				cart.setEntries(entries);
			}
		}
		request.getSession().setAttribute("cart", cart);
		
		return "redirect:/cart";
	}
	
	@RequestMapping("/updateQuantity-{code}")
	public String updateQuantity(HttpServletRequest request,
			@PathVariable("code") String code,
			@RequestParam("quantity") int quantity) {
		
		CartData cart = null;
		cart = (CartData) request.getSession().getAttribute("cart");
		if(cart != null) {
			
			List<CartEntryData> entries = cart.getEntries();
			Optional<CartEntryData> entryToUpdate = entries.stream().filter(x -> x.getProduct().getCode().equals(code)).findFirst();
			
			if(entryToUpdate.isPresent()) {
				
				entries.forEach(x -> {if(x.getProduct().getCode().equals(entryToUpdate.get().getProduct().getCode()))
					x.setQuantity(quantity);});		
				cart.setEntries(entries);
				
				try {
					cartFacade.save(cart);
				} catch(Exception e) {
					LOG.error("Errore nell' update della quantita'");
				}
			}
			
			request.getSession().setAttribute("cart", cart);
		}
		
		
		return "redirect:/cart";
	}
	
	
}
