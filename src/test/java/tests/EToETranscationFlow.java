package tests;

import java.io.File;

import java.util.concurrent.TimeUnit;

import services.LoginLogoutService;
import services.TransactionFlowService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EToETranscationFlow {

	public WebDriver webDriver;
	private int waitTimeout=60;
	private String baseURL ="http://www.walmart.com/";
	private LoginLogoutService loginLogoutService;
	private TransactionFlowService transactionFlowService;
	
	@Test
	public void setupAndLoginTest(){
		File file = new File("C:\\selenium-2.46.0\\libs\\ChromeDriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        System.out.println("Setting up the webDriver as ChromeDriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Navigating to the baseURL :" + baseURL);
        webDriver.navigate().to(baseURL);
        webDriver.manage().window().maximize();
        System.out.println("Executing the login service to sign in into existing account");
        loginLogoutService = new LoginLogoutService(webDriver);
        loginLogoutService.login();
        System.out.println("Asserting whether sign in was successful");
        Assert.assertTrue(webDriver.getPageSource().contains("Welcome"),
			    "Message did not appear.");
        System.out.println("Assertion passed and message 'Welcome to your Walmart account! is displayed");
	}
	
	
	@Test
	public void transactionFlowTest(){
		
		transactionFlowService = new TransactionFlowService(webDriver);
		transactionFlowService.searchAnItem();
		transactionFlowService.addItemToShoppingCart();
		System.out.println("Asserting that only one item is present in cart");
		Assert.assertTrue(webDriver.getPageSource().contains("1 item."),
			    "Message did not appear.");
		System.out.println("Assertion passed");
		transactionFlowService.removeItemFromShoppingCart();
		//loginLogoutService.logout();
		webDriver.close();
	}
}
