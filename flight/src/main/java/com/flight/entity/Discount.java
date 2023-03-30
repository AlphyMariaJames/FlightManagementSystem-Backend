package com.flight.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discount_entity")
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String discountCode;
	private Integer discountPercent;
	
	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Discount(Integer id, String discountCode, Integer discountPercent) {
		super();
		Id = id;
		this.discountCode = discountCode;
		this.discountPercent = discountPercent;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public Integer getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}
	@Override
	public String toString() {
		return "Discount [Id=" + Id + ", discountCode=" + discountCode + ", discountPercent=" + discountPercent + "]";
	}
	
	

}
