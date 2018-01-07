package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class Language implements Serializable{
	
	private static final long serialVersionUID = -7001602948310834334L;

	@Id
	@Column (name="isocode")
	private String isocode;
	
	@Column (name="name")
	private String name;

	public String getIsocode() {
		return isocode;
	}

	public void setIsocode(String isocode) {
		this.isocode = isocode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Language() {
		
	}
	public Language(String isocode, String name) {
		this.isocode = isocode;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Language [isocode=" + isocode + ", name=" + name + "]";
	}

	
}
