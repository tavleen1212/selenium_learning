import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Businesslogic.Businesslogic;
import Keywords.Keywords;
import Selenium.SeleniumInitialize;


public class scrip2 extends SeleniumInitialize 
{
		public Keywords keyword = new Keywords();
		public Businesslogic scenarios = new Businesslogic();
		
		public WebElement element;
		String telecomurl= "http://demo.guru99.com/telecom/index.html";
		
		 @DataProvider(name = "customerdetails")
		 public static Object[][] customerdetails()
		 {
		       return new Object[][] { 
		    	   					   { "mahattam", "tomar","matty@gmail.com","neerim","1234" }, 
		    	   					   { "tavleen", "kaur","matty@gmail.com","neerim","1234" },
		    	   					   { "test", "kaur","matty@gmail.com","neerim","vnbnbn" },
		    	   					   
		       						  };
		 
		 }
		
		@Test(groups = {"scrip2"} , dataProvider = "customerdetails")
		public void testcase1(String firstname, String lastname,String email,String address,String mobilenumber)
		{
		
			scenarios.AddCustomerDone(telecomurl,firstname,lastname,email,address,mobilenumber);
		}
		
	
	
}
