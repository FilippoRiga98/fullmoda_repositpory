package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="website")
public class Website implements Serializable {

	private static final long serialVersionUID = 8896356598765703885L;

	@Id
	@Column(name ="website_id")
	private String websiteId;
	
	@OneToOne
	@JoinColumn (name="language")
	private Language language;

	public String getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(String websiteId) {
		this.websiteId = websiteId;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
}
