package it.sopra.stage.fullmoda.dto;

import java.math.BigDecimal;

public class PriceData {

	private BigDecimal value;
	private CurrencyData currency;
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public CurrencyData getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyData currency) {
		this.currency = currency;
	}
	public PriceData(BigDecimal value, CurrencyData currency) {
		this.value = value;
		this.currency = currency;
	}
	
	
}
