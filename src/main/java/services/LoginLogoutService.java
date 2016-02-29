package services;

import org.openqa.selenium.WebDriver;


import pageObjects.LoginLogoutPage;

public class LoginLogoutService {

	private LoginLogoutPage loginLogoutPage;
	
	public LoginLogoutService(WebDriver webDriver){
		loginLogoutPage = new LoginLogoutPage(webDriver);
	}
	
	
	public void login(){
		loginLogoutPage.clickSignIn();
		loginLogoutPage.typeUserName("mhdoshi@asu.edu");
		loginLogoutPage.typePassword("helloWorld");
		loginLogoutPage.clickLogin();
		loginLogoutPage.waitForPageToLoad();
	}
	
	
	public void logout(){
		loginLogoutPage.clickLogout();
		System.out.println("Logged out of the account");
	}
}
