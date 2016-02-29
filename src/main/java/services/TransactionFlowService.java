package services;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import pageObjects.ItemPage;
import pageObjects.SearchPage;
import pageObjects.YourShoppingCartPage;

import org.openqa.selenium.WebDriver;

public class TransactionFlowService {

private SearchPage searchPage;
private ItemPage itemPage;
private YourShoppingCartPage yourShoppingCartPage;
	
	public TransactionFlowService(WebDriver webDriver){
		searchPage = new SearchPage(webDriver);
		itemPage = new ItemPage(webDriver);
		yourShoppingCartPage = new YourShoppingCartPage(webDriver);
	}
	
	
	public void searchAnItem(){
		Random random = new Random();
		int randomNum = random.nextInt((3 - 0) + 1) + 0;
		List<String> listOfItems = new ArrayList<String>();
		listOfItems.add("tv");
		listOfItems.add("socks");
		listOfItems.add("dvd");
		listOfItems.add("toys");
		String item = listOfItems.get(randomNum);
		searchPage.typeInSearchBar(item);
		searchPage.clickSearch();
		searchPage.clickProductImage(item);
	}
	
	public void addItemToShoppingCart(){
		itemPage.addItemToCart();
		itemPage.clickOnViewCart();
		yourShoppingCartPage.waitForPageToLoad();
	}
	
	public void removeItemFromShoppingCart(){
		yourShoppingCartPage.removeItemFromCart();
	}
}
