package pageObjects;

import services.PageDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLogoutPage  {
	
private WebDriver page;
private PageDriver pageDriver;
	
	public LoginLogoutPage(WebDriver webDriver) {
		page = webDriver;
		pageDriver = new PageDriver(webDriver);
	}
	 
	public void clickSignIn()
	{
		System.out.println("Waiting for the Sign-In button to be enabled");
		pageDriver.waitforElementEnabled(By.xpath("//a[@class='header-account-signin']"));
		pageDriver.clickElement(By.xpath("//a[@class='header-account-signin']"));
		System.out.println("Clicked on the Sign-In button");
	}
	
	public void typeUserName(String uname)
	{
		System.out.println("Waiting for the login page to load");
		pageDriver.waitForElementVisible(By.id("login-username"));
		pageDriver.typeValueInField(page.findElement(By.id("login-username")), uname);
		System.out.println("Typed userName: " + uname  );
	}
	
	public void typePassword(String password)
	{
		pageDriver.waitForElementVisible(By.id("login-password"));
		pageDriver.typeValueInField(page.findElement(By.id("login-password")), password);
		System.out.println("Typed password: " + password);
	}
	
	
	public void clickLogin(){
		pageDriver.clickElement(By.xpath("//button[@data-automation-id='login-sign-in']"));
		System.out.println("Sign in button clicked after typing username and password");
	}
	
	public void waitForPageToLoad(){
		System.out.println("Waiting for the page to load");
		pageDriver.waitForElementVisible(By.xpath("//h1[starts-with(text(),'Welcome')]"));
	}
	
	public void clickLogout()
	{
		pageDriver.moveMouse(By.className("dropdown-link js-flyout-toggle flyout-toggle"));
		pageDriver.clickElementByLinkText("Sign Out ");
	}
}
