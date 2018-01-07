package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class PaymentMethod implements Serializable {

	private static final long serialVersionUID = 6012181409124564952L;

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public PaymentMethod() {
		
	}

	public PaymentMethod(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "PaymentMethod [code=" + code + ", name=" + name + "]";
	}
	
	
}
