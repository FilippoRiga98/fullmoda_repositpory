package it.sopra.stage.fullmoda.dto;

public class WebsiteData {

	private String websiteId;
	
	private LanguageData language;

	public String getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(String websiteId) {
		this.websiteId = websiteId;
	}

	public LanguageData getLanguage() {
		return language;
	}

	public void setLanguage(LanguageData language) {
		this.language = language;
	}

	public WebsiteData(String websiteId, LanguageData language) {
		this.websiteId = websiteId;
		this.language = language;
	}

	@Override
	public String toString() {
		return "WebsiteData [websiteId=" + websiteId + ", language=" + language + "]";
	}
	
	
}
