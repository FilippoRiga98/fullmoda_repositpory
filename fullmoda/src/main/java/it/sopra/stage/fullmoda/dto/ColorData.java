package it.sopra.stage.fullmoda.dto;

public class ColorData {

	private String code;
	private String htmlCode;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getHtmlCode() {
		return htmlCode;
	}
	public void setHtmlCode(String htmlCode) {
		this.htmlCode = htmlCode;
	}
	public ColorData(String code, String htmlCode) {
		super();
		this.code = code;
		this.htmlCode = htmlCode;
	}
	
	
}
