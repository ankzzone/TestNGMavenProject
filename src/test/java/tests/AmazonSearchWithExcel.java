package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AmazonPage;
import utils.ExcelUtils;
import utils.Driver;

public class AmazonSearchWithExcel {

	@BeforeMethod
	public void setup() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	@AfterMethod
	public void quitDriver() {
		Driver.quitDriver();
	}
	
	
	@Test(enabled = false)
	public void test() {
		ExcelUtils.openExcelFile("./src/test/resources/testData/searchItems.xlsx", "items");
		 System.out.println("Total row count: " + ExcelUtils.getUsedRowsCount());
		System.out.println(ExcelUtils.getCellData(0, 0));
	}
	
  @Test(dataProvider = "searchItem", enabled = true)
  public void AmazonSearchTest(String item) {
	  AmazonPage amazonpage = new AmazonPage();
	  Driver.getDriver().get("https://amazon.com");
	  amazonpage.searchBox.sendKeys(item);
	  amazonpage.searchBtn.click();
	 
	  // actual text = "coffee maker" and item = coffee maker
	  // we need to get rid of the double quotes("")
	  String actualText = amazonpage.searchedItemText.getText().substring(1, amazonpage.searchedItemText.getText().length()-1);
	 // System.out.println(item);
	  Assert.assertEquals(actualText, item);
	    
  }
  
  @DataProvider
  public String[] searchItem() {
	  
	  String[] items = ExcelUtils.getExcelDataInAColumn("./src/test/resources/testData/searchItems.xlsx", "items");
	  
	  return items;
	  
  }
	
}
