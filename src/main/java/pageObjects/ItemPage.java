package pageObjects;

import services.PageDriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {


	private WebDriver page;
	private PageDriver pageDriver;
		
	public ItemPage(WebDriver webDriver) {
		page = webDriver;
		pageDriver = new PageDriver(webDriver);
	}
	
	public void addItemToCart(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pageDriver.waitforElementEnabled(By.id("WMItemAddToCartBtn"));
		pageDriver.clickElement(By.id("WMItemAddToCartBtn"));
		System.out.println("Add to cart button clicked");
	}
	
	public void clickOnViewCart(){
		pageDriver.waitforElementEnabled(By.id("PACViewCartBtn"));
		pageDriver.clickElement(By.id("PACViewCartBtn"));
		System.out.println("View cart button clicked");
	}
	
}
