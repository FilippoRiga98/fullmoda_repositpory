package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -4013846143858009909L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="orderId")
	private Long id;
	
	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@Column(name="total_price",  precision = 19, scale = 4)
	private BigDecimal totalPrice;
	
	@Column(name="order_date")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	@OneToOne
	@JoinColumn(name="shipping_address")
	private Address shippingAddress;
	
	@OneToOne
	@JoinColumn(name="billing_address")
	private Address billingAddress;
	
	@OneToOne
	@JoinColumn(name="payment_method")
	private PaymentMethod paymentMethod;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public Order() {
		
	}

	public Order(it.sopra.stage.fullmoda.entities.Cart cart, BigDecimal totalPrice, Date orderDate,
			Address shippingAddress, Address billingAddress, PaymentMethod paymentMethod) {
		this.cart = cart;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", cart=" + cart + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate
				+ ", shippingAddress=" + shippingAddress + ", billingAddress=" + billingAddress + ", paymentMethod="
				+ paymentMethod + "]";
	}
	
	
	
}
