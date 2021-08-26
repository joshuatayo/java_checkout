package com.checkout;

import java.util.List;
import java.util.Scanner;

import com.checkout.bean.Item;

public class UI {
	
	
	public UI() {
		title();
		displayStoreItems();
		scanItem();
	}
	
	private void title() {
		System.out.println("<!=======================");
        System.out.println("Items in Store");
        System.out.println("=======================!>");
        System.out.println("Special Offer");
        System.out.println("Buy 3 of SKU A for 1.30p");
        System.out.println("Buy 2 of SKU B for 0.45p");
        System.out.println("=======================!>");
	}
	
	private void displayStoreItems() {
        List<Item> items = new Items().getItems();
        String leftAlignFormat = "| %-5s | %-5.2f |%n";
		System.out.format("+-------+-------+%n");
		System.out.format("|  Sku  | Price |%n");
		System.out.format("+-------+-------+%n");
        for (Item itm: items) {
        	System.out.format(leftAlignFormat, 
            		itm.getSku() , +
            				itm.getUnitPrice() , +
            					itm.getSpecialPrice()
            );
        }
        System.out.format("+-------+-------+%n");
    }
	
	
	private void scanItem() {
		String keepScanning;
	    String itemSku;
	    
	    Scanner scanner = new Scanner(System.in);
	    Checkout checkout = new Checkout();
	    
	    
	    do
	    {
	        System.out.print("Scan Item by using Item SKU: ");
	        itemSku = scanner.next().toUpperCase();
	        
	        checkout.addItemToCheckoutListBySku(itemSku);
	        checkout.printCheckOutItems();

	        System.out.print("Do you still have item to scan "
	            + "(y/n)?: ");
	        keepScanning = scanner.next();
	        if (keepScanning.equals("n")) {
	        	System.out.println("CheckOut");
	        	checkout.printCheckOutItems();
	        	System.out.println("Thanks For Shopping!");
	        	System.exit(0);
	        } 
	    }
	    while (keepScanning.equalsIgnoreCase("y"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UI();
	}
}
