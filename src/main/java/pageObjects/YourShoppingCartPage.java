package pageObjects;

import services.PageDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourShoppingCartPage {

	private WebDriver page;
	private PageDriver pageDriver;
		
	public YourShoppingCartPage(WebDriver webDriver) {
		page = webDriver;
		pageDriver = new PageDriver(webDriver);
	}
	
	
	public void removeItemFromCart(){
		pageDriver.waitforElementEnabled(By.id("CartRemItemBtn"));
		pageDriver.clickElement(By.id("CartRemItemBtn"));
		System.out.println("Item removed from cart");
	}
	
	public void waitForPageToLoad(){
		pageDriver.waitforElementEnabled(By.id("CartRemItemBtn"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
