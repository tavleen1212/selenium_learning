package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class SeleniumInitialize {
	
	public static WebDriver driver;
	
	@BeforeSuite (alwaysRun = true) 
	public void Initialise()
	{
		System.setProperty("webdriver.gecko.driver", "/Users/mahattam/eclipse-workspace/Agileproject/Lib/geckodriver");
		driver= new FirefoxDriver();
	}
	
	
	@AfterTest (alwaysRun = true) 
	public void endprogram()
	{
		driver.quit();
	}

		
}
