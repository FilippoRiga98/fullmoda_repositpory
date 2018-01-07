package it.sopra.stage.fullmoda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="color_product")
public class ColorVariantProduct  implements Serializable{

	private static final long serialVersionUID = 161584907401149534L;

	@Id
	@Column(name="code")
	private String code;
	
	@OneToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="color")
	private Color color;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="baseproduct")
	private BaseProduct baseproduct;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="colorVariantProduct", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<SizeVariantProduct> sizeVariantProducts;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public ColorVariantProduct() {

	}
	
	
	public List<SizeVariantProduct> getSizeVariantProducts() {
		return sizeVariantProducts;
	}
	public void setSizeVariantProducts(List<SizeVariantProduct> sizeVariantProducts) {
		this.sizeVariantProducts = sizeVariantProducts;
	}
	public ColorVariantProduct(String code, Color color, BaseProduct baseProduct) {

		this.code = code;
		this.color = color;
		this.baseproduct= baseProduct;
	}
	
	public void addSizeVariantProduct(SizeVariantProduct sizeVariantProduct) {
		if(this.sizeVariantProducts == null) {
			this.sizeVariantProducts = new ArrayList<SizeVariantProduct>();
		}
		this.sizeVariantProducts.add(sizeVariantProduct);
	}
	
	public void addSizeVariantProductList(List<SizeVariantProduct> sizeVariantProductList) {
		if(this.sizeVariantProducts == null) {
			this.sizeVariantProducts = new ArrayList<SizeVariantProduct>();
		}
		this.sizeVariantProducts.addAll(sizeVariantProductList);
	}
	
	@Override
	public String toString() {
		return "ColorVariantProduct [code=" + code + ", color=" + color + ", sizeVariantProducts=" + sizeVariantProducts
				+ "]";
	}
	
	
	
	
}
