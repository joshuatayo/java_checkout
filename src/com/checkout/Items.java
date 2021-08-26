package com.checkout;

import java.util.ArrayList;
import java.util.List;

import com.checkout.bean.Item;

public class Items {
	
	private final List<Item> items = new ArrayList<Item>();
	
	public Items () {
		this.initStoreItems();
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void initStoreItems() {
		String [] itemSku = {"A", "B", "C", "D"};
		Double [] itemPrice = {0.50, 0.30, 0.20, 0.15};
		Double [] specialPrice = {1.30, 0.45, 0.0, 0.0,};
		
		for (int i=0; i < itemSku.length; i++) {
			this.items.add(new Item(itemSku[i], itemPrice[i], specialPrice[i]));
		}
	}
}
