package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 14906121048180977L;
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="type")
	private String customerType;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	@Column(name="birthdate")
	private Date birthDate;
	
	@Column(name="birthplace")
	private String birthPlace;
	
	@Column(name="privacy_agreement")
	private boolean privacyAgreement;
	
	@Column(name="fiscalcode")
	private String fiscalCode;
	
	@OneToOne (cascade= CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public boolean isPrivacyAgreement() {
		return privacyAgreement;
	}

	public void setPrivacyAgreement(boolean privacyAgreement) {
		this.privacyAgreement = privacyAgreement;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User() {
		
	}
	public User(String username, String name, String surname, String customerType, String email,
			String password, String phoneNumber, Date birthDate, String birthPlace, boolean privacyAgreement,
			String fiscalCode, Address address) {
	
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.customerType = customerType;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.privacyAgreement = privacyAgreement;
		this.fiscalCode = fiscalCode;
		this.address = address;
	}
	
	
	

}
