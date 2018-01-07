package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="base_product")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseProduct implements Serializable{

	
	private static final long serialVersionUID = 6474896975690468820L;
	
	@Id
	private String code;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	
	@Column(name="onlinedate")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date onlineDate;
	
	@Column(name="offlinedate")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date offlineDate;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="baseproduct", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ColorVariantProduct> colorVariants;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="baseProduct", cascade = CascadeType.ALL)
	private List<Price> priceList;
	
	@Override
	public String toString() {
		return "BaseProduct [code=" + code + ", name=" + name + ", description=" + description + ", onlineDate="
				+ onlineDate + ", offlineDate=" + offlineDate + "]";
	}
	public BaseProduct() {
		
	}
	public BaseProduct(String code, String name, String description, Date onlineDate, Date offlineDate) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.onlineDate = onlineDate;
		this.offlineDate = offlineDate;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getOnlineDate() {
		return onlineDate;
	}
	public void setOnlineDate(Date onlineDate) {
		this.onlineDate = onlineDate;
	}
	public Date getOfflineDate() {
		return offlineDate;
	}
	public void setOfflineDate(Date offlineDate) {
		this.offlineDate = offlineDate;
	}
	public List<ColorVariantProduct> getColorVariants() {
		return colorVariants;
	}
	public void setColorVariants(List<ColorVariantProduct> colorVariants) {
		this.colorVariants = colorVariants;
	}

	public void addColorVariant(ColorVariantProduct colorVariant) {
		if(getColorVariants() == null) {
			this.colorVariants = new ArrayList<ColorVariantProduct>();
		}
		getColorVariants().add(colorVariant);
	}
	public void addColorVariants(List<ColorVariantProduct> colorVariants) {
		if(getColorVariants() == null) {
			this.colorVariants = new ArrayList<ColorVariantProduct>();
		}
		getColorVariants().addAll(colorVariants);
	}
	
	public void addPrice(Price price) {
		if(priceList == null) {
			this.priceList = new ArrayList<Price>();
		}
		this.priceList.add(price);
	}
	
	public void addPriceList(List<Price> priceList) {
		if(priceList == null) {
			this.priceList = new ArrayList<Price>();
		}
		this.priceList.addAll(priceList);
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
		BaseProduct other = (BaseProduct) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
}
