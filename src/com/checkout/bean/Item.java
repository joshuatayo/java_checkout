package com.checkout.bean;

public class Item {
	
	private String sku;
	private Double unitPrice;
	private Double specialPrice;
	
	public Item() {
		
	}

	public Item(String sku, Double unitPrice, Double specialPrice) {
		this.sku = sku;
		this.unitPrice = unitPrice;
		this.specialPrice = specialPrice;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}

	@Override
	public String toString() {
		return "Item [sku=" + sku + ", unitPrice=" + unitPrice + ", specialPrice=" + specialPrice + "]";
	}
}
