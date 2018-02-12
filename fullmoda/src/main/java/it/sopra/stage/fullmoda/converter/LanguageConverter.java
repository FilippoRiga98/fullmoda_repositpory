package it.sopra.stage.fullmoda.converter;

import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.LanguageData;
import it.sopra.stage.fullmoda.model.Language;

@Component
public class LanguageConverter {

	public LanguageData convert(Language language) {
		return new LanguageData (language.getIsocode(), language.getName());
	}
	
	public Language convert(LanguageData source) {
		return new Language(source.getIsocode(), source.getName());
	}
}
