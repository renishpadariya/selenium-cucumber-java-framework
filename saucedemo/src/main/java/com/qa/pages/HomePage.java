package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.Util;

public class HomePage {
	private WebDriver driver;
	private By productsHeader = By.cssSelector("span.title[data-test='title']");
	private By inventoryItems = By.cssSelector("div[data-test='inventory-item']");
	private By AddtoCart=By.xpath(".//button[contains(@data-test,'add-to-cart')]");
	private By Inventory_item_price=By.className("inventory_item_price"); 
	private By inventoryItemName =By.cssSelector("div[data-test='inventory-item-name']");

    private WebElement highestPriceAddToCartBtn;
    private Util util;
    private String selectedItemName;
    private double selectedItemPrice;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		util = new Util(driver);
	}
	public boolean verify_products_page() {
		
	        return driver.findElement(productsHeader).getText().equals("Products");
	    }
	public void select_highest_price_item() {
		 List<WebElement> items = util.findElements(inventoryItems, 10);

	        double maxPrice = 0.0;

	        for (WebElement item : items) {

	            String priceText = item
	                    .findElement(Inventory_item_price)
	                    .getText()
	                    .replace("$", "");
	            double price = Double.parseDouble(priceText);

	            if (price > maxPrice) {
	                maxPrice = price;
	                selectedItemPrice = price;
	                selectedItemName = item.findElement(inventoryItemName).getText();
	                highestPriceAddToCartBtn = item.findElement(AddtoCart);
	            }
	}
	}
	public void add_selected_item_to_cart() {
		highestPriceAddToCartBtn.click();
		System.out.println("Add to Cart item Name: " + selectedItemName);
	    System.out.println("Price: $" + selectedItemPrice);
		
	}
		
	
}
