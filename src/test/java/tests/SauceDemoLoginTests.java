package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SauceDemoPage;
import utils.Driver;

public class SauceDemoLoginTests {

	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	@AfterMethod
	public void quitDriver() {
		Driver.quitDriver();
	}
	@Test (dataProvider = "credential")
	public void credentialTest(String username, String password) {
		Driver.getDriver().get("https://saucedemo.com");
		
		System.out.println(username + "  " + password);
		
		SauceDemoPage page = new SauceDemoPage();
		page.username.sendKeys(username);
		page.password.sendKeys(password);
		page.loginButton.click();
		
		Assert.assertTrue(page.errormessage.getText().contains("Username and password do not match"));
	}
	
	@DataProvider
	public String[][] credential(){
		String[][] names = new String[2][2];
		names[0][0] = "standard_user";
		names[0][1] = "password1";
		
		names[1][0] = "standard_user11";
		names[1][1] = "secret_sauce";
		return names;
	}
	
	
}
