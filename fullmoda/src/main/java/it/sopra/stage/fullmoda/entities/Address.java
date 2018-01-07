package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable {

	private static final long serialVersionUID = -4468240752515807448L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_Address")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="line1")
	private String line1;
	
	@Column(name="line2")
	private String line2; 
	
	@Column(name="zipcode")
	private String zipCode;
	
	@Column(name="town")
	private String town;
	
//	@JoinColumn(name="country")
//	@OneToOne (mappedBy="code")//(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name="country_code")
	@OneToOne
	private Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Address() {
		
	}

	public Address(String title, String line1, String line2, String zipCode, String town, Country country) {
		this.title = title;
		this.line1 = line1;
		this.line2 = line2;
		this.zipCode = zipCode;
		this.town = town;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", title=" + title + ", line1=" + line1 + ", line2=" + line2 + ", zipCode="
				+ zipCode + ", town=" + town + ", country=" + country + "]";
	}
	
	
}
