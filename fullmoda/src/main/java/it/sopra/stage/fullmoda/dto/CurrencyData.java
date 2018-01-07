package it.sopra.stage.fullmoda.dto;

public class CurrencyData {

	private String code;
	private String symbol;
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
	public CurrencyData(String code, String symbol) {
		this.code = code;
		this.symbol = symbol;
	}
	
	
}
