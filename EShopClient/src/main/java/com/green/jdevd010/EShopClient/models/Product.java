package com.green.jdevd010.EShopClient.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@Column(name = "productID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productID;
	
	@Column(name= "name")
	private String productName;
	private String img ;
	private Long price_old ;
	private Long price_new ;
	private String intro;
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Long getPrice_old() {
		return price_old;
	}
	public void setPrice_old(Long price_old) {
		this.price_old = price_old;
	}
	public Long getPrice_new() {
		return price_new;
	}
	public void setPrice_new(Long price_new) {
		this.price_new = price_new;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
}
