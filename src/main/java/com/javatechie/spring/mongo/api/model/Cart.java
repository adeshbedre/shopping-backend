package com.javatechie.spring.mongo.api.model;

import lombok.ToString;

@ToString
public class Cart {
	
	private Products product;

	private Integer quantity;

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


}
