package com.checkout;

import java.util.ArrayList;
import java.util.List;

import com.checkout.bean.CheckOutItem;
import com.checkout.bean.Item;


public class Checkout {
	List<CheckOutItem> checkout = new ArrayList<CheckOutItem>();
	List<Item> cart = new ArrayList<Item>();
    Double totalPrice = 0.00;
    
    public void addItemToCheckoutListBySku(String sku) {
        Item item = getItemBySku(sku);
        addToCheckOut(item);
    }
    
    //get item for the item list by Sku
    private Item getItemBySku(String sku) {
        Item item = null;
        List<Item> items = new Items().getItems();
        
        for (Item itm: items) {
        	if (itm.getSku().toString().equals(sku)) {
            	item = itm;
                break;
            }
        }
        if (item == null) {
            throw new NullPointerException(
                  " :: Item not Available.");
         }
        return item;
    }
    
    // -------------------------------------------------------
    // Adds an item to the checkout list.
    // -------------------------------------------------------
	public void addToCheckOut(Item item)
    {
    	int qty = 1;
    	Double price = item.getUnitPrice() *  qty;
    	int A_SPECIAL_PRICE = 3;
    	int B_SPECIAL_PRICE = 2;
    	if (checkout == null) {
        	checkout.add(new CheckOutItem(item, qty, price));
        } else {
        	int index = exists(item, checkout);
        	if(index == -1) {
	        	checkout.add(new CheckOutItem(item, qty, price));
			} else {
				int newQuantity = checkout.get(index).getQuantity() + 1;
				checkout.get(index).setQuantity(newQuantity);
				if( checkout.get(index).getQuantity().equals(A_SPECIAL_PRICE) 
						&& checkout.get(index).getItem().getSku().toString().equals("A")) {
					checkout.get(index).setPrice(checkout.get(index).getItem().getSpecialPrice());
				} else if (checkout.get(index).getQuantity().equals(B_SPECIAL_PRICE) 
						&& checkout.get(index).getItem().getSku().toString().equals("B")) {
					checkout.get(index).setPrice(checkout.get(index).getItem().getSpecialPrice());
				} else {
					checkout.get(index).setPrice(newQuantity * checkout.get(index).getPrice());
				}
			}
		}
    	
    }
    
    //check if item exists in checkout list
    private int exists(Item item, List<CheckOutItem> checkout) {
		for (int i = 0; i < checkout.size(); i++) {
			if (checkout.get(i).getItem().getSku().toString() == item.getSku().toString()) {
				return i;
			}
		}
		return -1;
	}
    
    //show the list of checkout items
    void printCheckOutItems() {
    	String leftAlignFormat = "| %-3s | %-5d | %-7.2f |%n";
    	double totalAmount = 0;
		System.out.format("+-----+-------+---------+%n");
		System.out.format("| Sku |  Qty  |  Price  |%n");
		System.out.format("+-----+-------+---------+%n");
		for (CheckOutItem crt: checkout) {
			totalAmount += crt.getPrice();
            System.out.format(leftAlignFormat, 
            		crt.getItem().getSku()  , +
            			crt.getQuantity() ,    +
            				crt.getPrice()
            );
        }
		System.out.format("+-----+-------+---------+%n");
		System.out.format("|Total Amount |  "+totalAmount+"  |%n");
        System.out.format("+-----+-------+---------+%n");
    }    
}
