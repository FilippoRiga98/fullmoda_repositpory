package it.sopra.stage.fullmoda.listeners;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.session.Session;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.facade.CartFacade;

public class DefaultSpringSessionStrategy implements HttpSessionStrategy {

	private final static Logger LOG = Logger.getLogger(DefaultSpringSessionStrategy.class);
		
	private CookieHttpSessionStrategy cookieStrategy;
	
	@Autowired
	private CartFacade cartFacade;
	
	public DefaultSpringSessionStrategy() {
		cookieStrategy = new CookieHttpSessionStrategy();
	}
	
	@Override
	public String getRequestedSessionId(HttpServletRequest request) {
		return cookieStrategy.getRequestedSessionId(request);
	}

	@Override
	public void onInvalidateSession(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("cart");
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
			CartData cart = cartFacade.getCartByUser(email);
			request.getSession().setAttribute("cart", cart);
			LOG.info("Carrello trovato e aggiunto alla sessione per l'utente: " + email);
		} 
		else {
			request.getSession().setAttribute("cart", new CartData());
			LOG.info("CARRELLO VUOTO");
		}
	}
	
}
