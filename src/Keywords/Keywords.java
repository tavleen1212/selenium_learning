package Keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Selenium.SeleniumInitialize;

public class Keywords extends SeleniumInitialize {
	
	private static WebElement element=null;

	public WebElement getElement(String Locator,String value)
	{
		WebElement el=null;
		if(Locator.trim().toUpperCase().equals("ID"))
		{
			el= driver.findElement(By.id(value));
			
		}else if(Locator.trim().toUpperCase().equals("NAME"))
		{
			el= driver.findElement(By.name(value));
			
		}else if(Locator.trim().toUpperCase().equals("XPATH"))
		{
			el= driver.findElement(By.xpath(value));
			
		}else if(Locator.trim().toUpperCase().equals("LINK"))
		{
			el=driver.findElement(By.linkText(value));
			
		}else if(Locator.trim().toUpperCase().equals("PARTIALLINK"))
		{
			el=driver.findElement(By.partialLinkText(value));
			
		}else if(Locator.trim().toUpperCase().equals("TAGNAME"))
		{
			el =driver.findElement(By.tagName(value));
			
		}else if(Locator.trim().toUpperCase().equals("CSS"))
		{
			el = driver.findElement(By.cssSelector(value));
			
		}else if(Locator.trim().toUpperCase().equals("CLASS"))
		{
			el = driver.findElement(By.className(value));
		}
		return el;
	}

	
	public void Open(String url)
	{
		try
		{
			driver.get(url);
		}catch(Exception e)
		{
			Reporter.log("Exception in open",true);
		}
	}
	public void click(String locatortype, String locator_value, String reportingpurposeName)
	{		
		try
		{
			element=getElement(locatortype, locator_value);
			element.click();
			Reporter.log(reportingpurposeName +" Is Clicked Successfully",true);

		}catch(Exception e)
		{
			Reporter.log("Exception in click",true);
		}
	}
	
	public void entertext(String locatortype, String locator_value, String text)
	{	
		try
		{
			element = getElement(locatortype, locator_value);
			element.sendKeys(text);
			Reporter.log(text +" Is entered Successfully",true);
			
		}catch(Exception e)
		{
			Reporter.log(locator_value+"Element not found in entertext function",true);
		}
		
	}
	
	public void select_dropdown(String locatortype, String locator_value, String text)
	{
		element = getElement(locatortype, locator_value);
		Select accno=new Select(element);
		accno.selectByVisibleText(text);
	}
	
	public String getText(String locatortype, String locator_value)
	{
		element = getElement(locatortype, locator_value);
		return element.getText();
	}
	
	
}
