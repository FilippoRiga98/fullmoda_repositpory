package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_entries")
public class CartEntry implements Serializable {

	private static final long serialVersionUID = -2582703987960111108L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idcart_entries")
	private Long entryId;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="product")
	private SizeVariantProduct product;
	
	@Column(name="quantity")
	private int quantity;

	

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public SizeVariantProduct getProduct() {
		return product;
	}

	public void setProduct(SizeVariantProduct product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartEntry() {
		
	}

	public CartEntry(SizeVariantProduct product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartEntry [entryId=" + entryId + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
	
	
}
