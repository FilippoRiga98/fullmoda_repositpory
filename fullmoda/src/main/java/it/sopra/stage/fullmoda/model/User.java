package it.sopra.stage.fullmoda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
public class User implements Serializable,UserDetails {

	private static final long serialVersionUID = 14906121048180977L;
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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

	public User(String name, String surname, String customerType, String email,
			String password, String phoneNumber, Date birthDate, String birthPlace, boolean privacyAgreement,
			String fiscalCode, Address address) {
	
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


	public User(String name, String surname, String customerType, String email, String password,
			boolean privacyAgreement) {
		this.name = name;
		this.surname = surname;
		this.customerType = customerType;
		this.email = email;
		this.password = password;
		this.privacyAgreement = privacyAgreement;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(customerType));
		return authorities;
	}


	@Override
	public boolean isAccountNonExpired()
	{
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked()
	{
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired()
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public String getUsername()
	{
		return email;
	}
}
