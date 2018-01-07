package it.sopra.stage.fullmoda.dto;

public class CartEntryData {
	
	private Long id;
	private SizeVariantProductData product;
	private int quantity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SizeVariantProductData getProduct() {
		return product;
	}
	public void setProduct(SizeVariantProductData product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartEntryData(Long id, SizeVariantProductData product, int quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartDataEntry [id="+id+", product=" + product + ", quantity=" + quantity + "]";
	}
	
	
}
