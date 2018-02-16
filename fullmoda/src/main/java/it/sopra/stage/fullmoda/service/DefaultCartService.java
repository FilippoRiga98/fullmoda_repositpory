package it.sopra.stage.fullmoda.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.sopra.stage.fullmoda.dao.CartRepository;
import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.CartEntry;

@Component
public class DefaultCartService implements CartService {

	private static final Logger LOG = Logger.getLogger(DefaultCartService.class);
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart getCartByUser(String email) {
		Cart cart = cartRepository.findByUserEmail(email);
		LOG.info(cart);
		return cart;
	}

	@Override
	@Transactional
	public List<CartEntry> removeFromCart(String productCode, Long cartId) {
		//Senza richiamare la repository elimina dal DB la entry selezionata
		Cart cart = cartRepository.findOne(cartId);
		List<CartEntry> entries = cart.getCartEntries();
		entries.removeIf(x -> x.getProduct().getCode().equals(productCode));
		LOG.info("Entry eliminata, per il carrello di id: " + cartId + " con codice prodotto: " + productCode);
		return entries;
	}

	@Override
	@Transactional
	public List<CartEntry> removeAllFromCart(Long cartId) {
		
		Cart cart = cartRepository.findOne(cartId);
		List<CartEntry> entries = cart.getCartEntries();
		entries.clear();
		LOG.info("Tutte le entry eliminate per il carrello di id: " + cartId);
		return entries;
	}

	@Override
	public void save(Cart cart) {
		cartRepository.save(cart);
	}

}
