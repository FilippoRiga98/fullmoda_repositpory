package it.sopra.stage.fullmoda.facade;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.WebsiteConverter;
import it.sopra.stage.fullmoda.dto.WebsiteData;
import it.sopra.stage.fullmoda.model.Website;
import it.sopra.stage.fullmoda.service.WebsiteService;

@Component
public class DefaultWebsiteFacade implements WebsiteFacade{

	@Autowired
	private WebsiteService websiteService;
	
	@Autowired
	private WebsiteConverter websiteConverter;
	
	@Override
	public WebsiteData getWebsite() {
		
		Locale locale = LocaleContextHolder.getLocale();
		String languageIsocode = locale.getLanguage();
		Website website = websiteService.getWebsiteByLanguage(languageIsocode);
		
		return websiteConverter.convert(website);
	}

}
