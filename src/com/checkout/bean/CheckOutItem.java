package com.checkout.bean;



public class CheckOutItem {
	
	private Item item;
    private Integer quantity;
	private double price;
	
	public CheckOutItem() {
	
	}

	public CheckOutItem(Item item, Integer quantity, double price) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CheckOutItem [item=" + item + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
