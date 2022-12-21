package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;

public class driver {
public static WebDriver driver;
	

	public static WebDriver getDriver() {
		String browser = System.getProperty("browser");
		if(browser == null) {
			browser = testDataReader.getProperty("browser");
		}
		
		if(driver == null) {
			switch(testDataReader.getProperty("browser")) {
			case "chrome":
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Desktop\\Tools\\chromedriver_win32\\chromedriver.exe");
				ChromeDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hp\\Desktop\\Tools\\chromedriver_win32\\geckodriver.exe");
				FirefoxDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				EdgeDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			default:
				//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\Desktop\\Tools\\chromedriver_win32\\chromedriver.exe");
				ChromeDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
		}
			return driver;
		}
		
		public static void quitDriver() {
			if(driver!= null) {
				driver.quit();
				driver = null;
			}
		}

}
