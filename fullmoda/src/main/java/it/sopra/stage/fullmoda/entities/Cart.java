package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart implements Serializable{

	private static final long serialVersionUID = -7045639864968292433L;

	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<CartEntry> cartEntries;
	
	@OneToOne
	@JoinColumn(name="user")
	private User user;
	
	@OneToOne
	@JoinColumn(name="website")
	private Website website;
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	

	public Cart() {
		
	}

	public Cart(User user, Website website) {
		this.user = user;
		this.website = website;
	}


	public void addCartEntry(CartEntry cartEntry) {
		if(this.cartEntries == null) {
			this.cartEntries = new LinkedList<>();
		}
		cartEntries.add(cartEntry);
	}
	
	public void addCartEntries(List<CartEntry> cartEntryList) {
		if(this.cartEntries == null) {
			this.cartEntries = new LinkedList<>();
		}
		cartEntries.addAll(cartEntryList);
	}


	public List<CartEntry> getCartEntries() {
		return cartEntries;
	}


	public void setCartEntries(List<CartEntry> cartEntries) {
		this.cartEntries = cartEntries;
	}


	public Website getWebsite() {
		return website;
	}


	public void setWebsite(Website website) {
		this.website = website;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", cartEntries=" + cartEntries + ", user=" + user + ", website=" + website + "]";
	}
	

	
	
	
}
