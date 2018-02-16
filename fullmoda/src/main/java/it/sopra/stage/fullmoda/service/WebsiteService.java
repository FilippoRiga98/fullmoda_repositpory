package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.model.Website;

public interface WebsiteService {

	Website getWebsiteByLanguage(String isocode);
}
