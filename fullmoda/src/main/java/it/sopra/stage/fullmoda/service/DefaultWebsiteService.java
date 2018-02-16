package it.sopra.stage.fullmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.sopra.stage.fullmoda.dao.WebsiteRepository;
import it.sopra.stage.fullmoda.model.Website;

@Service
public class DefaultWebsiteService implements WebsiteService{

	@Autowired
	private WebsiteRepository websiteRepository;
	
	@Override
	public Website getWebsiteByLanguage(String isocode) {
		
		return websiteRepository.findByLanguageName(isocode);
		
	}

}
