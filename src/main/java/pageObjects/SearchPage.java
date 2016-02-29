package pageObjects;

import java.util.List;


import services.PageDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	private WebDriver page;
	private PageDriver pageDriver;
		
	public SearchPage(WebDriver webDriver) {
		page = webDriver;
		pageDriver = new PageDriver(webDriver);
	}
	
	public void typeInSearchBar(String inputValue){
		System.out.println("Typing " + inputValue + " in the search bar");
		pageDriver.typeValueInField(page.findElement(By.id("search")), inputValue);
	}
	
	public void clickSearch(){
		System.out.println("Clicking on the search picture button");
		pageDriver.clickElement(By.xpath("//button[@class='searchbar-submit js-searchbar-submit']"));
	}
	
	public void clickProductImage(String item){
		
		if(item.equalsIgnoreCase("toys")){
			if(pageDriver.isElementDisplayed(By.linkText("\"toys\"")))
			{
				pageDriver.waitForElementVisible(By.linkText("\"toys\""));
				pageDriver.clickElementByLinkText("\"toys\"");
			}
		}
		pageDriver.waitforElementEnabled(By.xpath("//button[@class='btn btn-inverse js-feedback-btn js-feedback-btn-yes']"));
		List<WebElement> list = page.findElements(By.xpath("//a[@class='js-product-image']"));
		System.out.println(" Size of the list is: " + list.size());
		WebElement element= list.get(0);
		pageDriver.waitForWebElementEnabled(element);
		pageDriver.clickwebElement(element);
	}
	
}
