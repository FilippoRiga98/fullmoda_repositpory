package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class Currency implements Serializable {

	private static final long serialVersionUID = -8214279391635342281L;

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="symbol")
	private String symbol;
	
	@OneToOne
	@JoinColumn(name="country")
	private Country country;
	
	@Column(name="decimal")
	private int decimal;
	
	@Column(name="base")
	private boolean base;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getDecimal() {
		return decimal;
	}

	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}

	public boolean isBase() {
		return base;
	}

	public void setBase(boolean base) {
		this.base = base;
	}

	public Currency() {
		
	}
	public Currency(String code, String symbol, Country country, int decimal, boolean base) {
		this.code = code;
		this.symbol = symbol;
		this.country = country;
		this.decimal = decimal;
		this.base = base;
	}

	@Override
	public String toString() {
		return "Currency [code=" + code + ", symbol=" + symbol + ", country=" + country + ", decimal=" + decimal
				+ ", base=" + base + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
	
}
