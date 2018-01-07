package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="color")
public class Color implements Serializable{

	
	private static final long serialVersionUID = -1493620935407428384L;

	@Id
	@Column(name="code")
	private String code;

	@Column(name="html_code")
	private String html_code;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getHtml_code() {
		return html_code;
	}
	public void setHtml_code(String html_code) {
		this.html_code = html_code;
	}
	public Color() {
		
	}
	public Color(String code, String html_code) {
		
		this.code = code;
		this.html_code = html_code;
	}
	@Override
	public String toString() {
		return "Color [colorCode=" + code + ", html_code=" + html_code + "]";
	}
	
	
	
}
