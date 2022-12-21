package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CommonPage;
import pages.SignUpPage;
import utils.driver;
import utils.testDataReader;

public class SignUpTests {

	@BeforeMethod(groups = {"smoke-test"})
	public void setup() {
		driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	@AfterMethod(groups = {"smoke-test"})
	public void quitDriver() {
		driver.quitDriver();
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test 3");
	}
	@Test
	public void test4() {
		System.out.println("Test 4");
	}
	@Test(groups = {"smoke-test"})
	public void test5() {
		System.out.println("Test 5");
	}
	@Test (groups = {"smoke-test", "signupPage"}, description = "verify signup page components")
	public void signUpPageTest() {
		CommonPage commonpage = new CommonPage();
		SignUpPage signuppage = new SignUpPage();
		//when
		driver.getDriver().get(testDataReader.getProperty("appurl"));
		// and click
		Assert.assertTrue(commonpage.welcomeLink.isDisplayed());
		commonpage.welcomeLink.click();
		// and click
		Assert.assertTrue(commonpage.signUpButton.isDisplayed());
		commonpage.signUpButton.click();
		
		// verify the sign up page web components
		Assert.assertTrue(signuppage.signUpText.isDisplayed());
		
		// email field verification
		Assert.assertTrue(signuppage.emailFieldLabel.isDisplayed());
		Assert.assertEquals(signuppage.emailField.getAttribute("placeholder"), "Please Enter Your Email");
		
		// first name field verification
		Assert.assertTrue(signuppage.firstNameLabel.isDisplayed());
		Assert.assertEquals(signuppage.firstNameField.getAttribute("placeholder"), "Please Enter Your First Name");

		// last name field verification
		Assert.assertTrue(signuppage.lastNameLabel.isDisplayed());
		Assert.assertEquals(signuppage.lastNameField.getAttribute("placeholder"), "Please Enter Your Last Name");

		// password  field verification
		Assert.assertTrue(signuppage.passwordLabel.isDisplayed());
		Assert.assertEquals(signuppage.passwordField.getAttribute("placeholder"), "Please Enter Your Password");

		// google and facebook login verification
		Assert.assertTrue(signuppage.signWithGoogleLink.isDisplayed());
		Assert.assertTrue(signuppage.signWithFacebookLink.isDisplayed());
		
		// checkbox verification
		Assert.assertTrue(signuppage.subscribeCheckBox.isDisplayed());
		Assert.assertFalse(signuppage.subscribeCheckBox.isSelected());
		Assert.assertTrue(signuppage.subscribeToNewsletter.isDisplayed());
		
		// back and signup buttons
		Assert.assertTrue(signuppage.signUpbtn.isDisplayed());
		Assert.assertTrue(signuppage.backToLoginLink.isDisplayed());
		
		
	}
	
}
