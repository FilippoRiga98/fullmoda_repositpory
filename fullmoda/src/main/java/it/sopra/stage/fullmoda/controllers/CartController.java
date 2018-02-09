package it.sopra.stage.fullmoda.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.CartEntryData;
import it.sopra.stage.fullmoda.dto.ColorVariantProductData;
import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.facade.CartFacade;
import it.sopra.stage.fullmoda.facade.ProductFacade;
import it.sopra.stage.fullmoda.form.ProductForm;

@Controller
public class CartController {

	@Autowired
	private CartFacade cartFacade;
	
	@Autowired
	private ProductFacade productFacade;
	
	@PostMapping("/addToCart")
	public String addToCart(@ModelAttribute("productForm") final ProductForm productForm,
			HttpServletRequest request) {
		
		CartData cart = (CartData) request.getSession().getAttribute("SESSION_CART");			
		List<CartEntryData> entries = cart.getEntries();
		ProductData product = productFacade.findProduct(productForm.getBaseProductCode());
		ColorVariantProductData colorVariant = (ColorVariantProductData) product.getVariants().stream().filter(x -> x.getColorData().getHtmlCode().equals(productForm.getColor()));
		SizeVariantProductData sizeVariant = (SizeVariantProductData) colorVariant.getVariants().stream().filter(x -> x.getSize().getCode().equals(productForm.getSize()));		
		CartEntryData entry = new CartEntryData(null, sizeVariant, productForm.getQuantity());
		
		entries.add(entry);
		cart.setEntries(entries);
		request.getSession().setAttribute("SESSION_CART", cart);
		
		return "redirect/:p-" + productForm.getBaseProductCode();
	}
	
	@GetMapping("/removeProduct")
	public int removeProduct(final String productCode, final int quantity) {
		return cartFacade.removeFromCart(productCode, quantity);
	}
	
	@GetMapping("/cart")
	public String getCart(HttpServletRequest request, Model model) {	
		
		/*(String principal = SecurityContextHolder.getContext().getAuthentication().getName();
		CartData cartFromRepository = cartFacade.getCartByUser(principal);*/
		
		HttpSession session = request.getSession();
		//session.setAttribute("cart", cartFromRepository);
		CartData cartFromSession  = (CartData) session.getAttribute("SESSION_CART");
		
		model.addAttribute("SESSION_CART", cartFromSession);
		
		return "cart";
	}
	
	
}
