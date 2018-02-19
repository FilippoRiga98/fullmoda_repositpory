package it.sopra.stage.fullmoda.listeners;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.session.Session;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.CartEntryData;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.dto.WebsiteData;
import it.sopra.stage.fullmoda.facade.CartFacade;
import it.sopra.stage.fullmoda.facade.UserFacade;
import it.sopra.stage.fullmoda.facade.WebsiteFacade;

public class DefaultSpringSessionStrategy implements HttpSessionStrategy {

	private final static Logger LOG = Logger.getLogger(DefaultSpringSessionStrategy.class);
		
	private CookieHttpSessionStrategy cookieStrategy;
	
	@Autowired
	private CartFacade cartFacade;
	
	@Autowired
	private UserFacade userFacade;
	
	@Autowired
	private WebsiteFacade websiteFacade;
	
	public DefaultSpringSessionStrategy() {
		cookieStrategy = new CookieHttpSessionStrategy();
	}
	
	@Override
	public String getRequestedSessionId(HttpServletRequest request) {
		return cookieStrategy.getRequestedSessionId(request);
	}

	@Override
	public void onInvalidateSession(HttpServletRequest request, HttpServletResponse response) {
		cookieStrategy.onInvalidateSession(request, response);		
	}

	@Override
	public void onNewSession(Session session, HttpServletRequest request, HttpServletResponse response) {
		
		cookieStrategy.onNewSession(session, request, response);		
		String email = null;
		try {
			SecurityContext secContext = session.getAttribute("SPRING_SECURITY_CONTEXT");
			email = secContext.getAuthentication().getName();
		} catch (Exception e) {
			
			LOG.warn("Utente anonimo");
		}
		if(email != "ANONYMOUS" && email != null && email != "") {
			
			CartData cartDb = null;
			CartData cartSession = (CartData) session.getAttribute("cart");
			List<CartEntryData> entriesSession = cartSession.getEntries();
			try {
				cartDb = cartFacade.getCartByUser(email);
				if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
					List<CartEntryData> entriesDb = cartDb.getEntries();
					for(CartEntryData entrySession : entriesSession) {
						
						Optional<CartEntryData> optionalEntry = entriesDb.stream().filter(x -> x.getProduct().getCode()
								.equals(entrySession.getProduct().getCode())).findFirst();
						if(optionalEntry.isPresent()) {
							entriesDb.forEach(x -> {if(x.getProduct().getCode().equals(entrySession.getProduct().getCode()))
								x.setQuantity(x.getQuantity() + entrySession.getQuantity());});		
						}
						else {
							entriesDb.add(entrySession);
						}
						
					}
					cartDb.setEntries(entriesDb);
					cartFacade.save(cartDb);
				}
			} catch(Exception e) {
				LOG.warn("Non esiste nessun carrello per l'utente selezionato");
			}
			
			if(cartDb == null) {
				cartDb = new CartData();
				UserData user = userFacade.validateUser(email);
				WebsiteData website = websiteFacade.getWebsite();
				cartDb.setUser(user);
				cartDb.setWebsite(website);
				cartDb.setEntries(entriesSession);
				try {
					cartFacade.save(cartDb);
				} catch(Exception e) {
					LOG.error("Non riesco a salvare il carrello per l'utente " + email);
				}
			}
			session.setAttribute("cart", cartDb);
			LOG.info("Carrello trovato e aggiunto alla sessione per l'utente: " + email);
		} 
		else {
			session.setAttribute("cart", new CartData());
			LOG.info("CARRELLO VUOTO");
		}
	}
	
}
