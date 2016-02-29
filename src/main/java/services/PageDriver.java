package services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PageDriver {

	private WebDriver page;
	private int waitTimeout = 60;
	
	public PageDriver(WebDriver webDriver){
		page = webDriver;
	}
	
	
	public void waitforElementEnabled(By by) {
		for (int second = 0;; second++) {
			if (second >= waitTimeout) {
				break;
			}
			try { 
				boolean enabled = page.findElement(by).isEnabled();
				if (enabled)
					break; } 
			catch (Exception e) {}
		}
	}
	
	public void waitForWebElementEnabled(WebElement element){
		for (int second = 0;; second++) {
			if (second >= waitTimeout) {
				break;
			}
			try { 
				boolean enabled = element.isEnabled();
				if (enabled)
					break; } 
			catch (Exception e) {}
		}
	}
	
	public void waitForElementVisible(By by) {
		for (int second = 0;; second++) {
			if (second >= waitTimeout) {
				System.out.println("Element not visible: " + by.toString());
				break;
			}
			try { 
				if (isElementDisplayed(by)) 
					break; } 
			catch (Exception e) {}
		}
	}
	
	public boolean isElementDisplayed(By by) {
		boolean isElementVisible = false;
		WebElement element = null;
		try {
			element = page.findElement(by);
			isElementVisible = element.isDisplayed();
		} catch (Exception e) {}
		return isElementVisible;
	}
	
	 public void typeValueInField(WebElement webElement, String inputValue) {    	
	    	webElement.click();//set focus
	    	webElement.clear();
	    	webElement.sendKeys(inputValue);         
	    } 
	
	 public void clickElement(By by) {
	    	page.findElement(by).click();
	    }
	
	 public void clickwebElement(WebElement element){
		 Actions actions = new Actions(page);
		 actions.moveToElement(element).click().perform();
		 System.out.println("Clicked on first product");
	 }
	 
	 public void clickElementByLinkText(String linkText) {
	    	
	    	clickElement(By.linkText(linkText));
	    	
	    }
	 
	 public void moveMouse(By by){
	        Actions builder = new Actions(page);
	        Action hover = builder.moveToElement(page.findElement(by)).build();
	        hover.perform();
			
		}
	 
	 
	 private boolean isElementPresent(By by){
			
			return page.findElements(by).size() > 0;

		}
		/**
		 * isElementPresentById
		 * @param id
		 * @return boolean
		 */
		public boolean isElementPresentById(String id) {
			
			return isElementPresent(By.id(id));	
			
		}
}
