package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="size")
public class Size implements Serializable{

	private static final long serialVersionUID = -1114232192533211573L;

	@Id
	@Column(name="code")
	private String code;
	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public String toString() {
		return "Size [code=" + code + "]";
	}

	public Size() {
		
	}

	public Size(String code) {
		this.code = code;
	}


	

	
}
