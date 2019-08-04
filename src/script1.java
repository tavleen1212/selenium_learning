import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Businesslogic.Businesslogic;
import Keywords.Keywords;
import Selenium.SeleniumInitialize;

public class script1 extends SeleniumInitialize
{
	
	public Keywords keyword = new Keywords();
	public Businesslogic scenarios = new Businesslogic();
	
	
	String baseurl="http://demo.guru99.com/Agile_Project/Agi_V1/";
	String urlnew="http://demo.guru99.com/";
	String urlnew1="http://demo.guru99.com/test/upload/";
	String url="http://demo.guru99.com/V1/index.php";
	
	public WebElement element;
	
	
	@Parameters({"userid","password"})
	@Test (groups = { "agileproject", "all" })	
	public void testcase1(String userid,String password)
	{
		scenarios.bank_login(baseurl,userid, password);
		scenarios.check_account("Mini Statement","3308");
	}
	
	@Test (groups = { "checkbox","all" })	
	public void testcase2()
	{
		scenarios.checkbox_selection(urlnew);
		
	}
	
	@Test (groups = {"all","test"})
	public void testcase3()
	{
		scenarios.upload_file(urlnew1);
				
	}
	
	@Parameters({"username","pwd"})
	@Test (groups = {"all","bank"})
	public void testcase4(String username,String pwd)
	{
		scenarios.bank_login(url, username, pwd);
	}
	
	@Parameters({"username","pwd"})	
	@Test (groups = {"agileproject", "all"})
	 public void testcase5(String username,String pwd)
	 {
		scenarios.bank_login(url,username, pwd);
		scenarios.new_customer_create("demo", "male");
		
	 }
}




