package it.sopra.stage.fullmoda.dto;

public class LanguageData {
	
	private String isocode;
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
	public LanguageData(String isocode, String name) {
		this.isocode = isocode;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "LanguageData [isocode=" + isocode + ", name=" + name + "]";
	}
	
	
}
