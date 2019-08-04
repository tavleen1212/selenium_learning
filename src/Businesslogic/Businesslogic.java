package Businesslogic;

import org.testng.Reporter;

import Keywords.Keywords;

public class Businesslogic
{
	public Keywords keyword = new Keywords();
	
	public void bank_login(String url, String userid,String password)
	{
		try
		{
			keyword.Open(url);
			keyword.entertext("xpath", "//input[@name='uid']", userid);
			keyword.entertext("xpath", "//input[@name='password']", password);
			keyword.click("xpath","//input[@name='btnLogin']", "LoginButton");
			
		}catch(Exception e)
		{
			Reporter.log("Exception in bank_login scenarios",true);
		}
	}
	
	public void check_account(String statement_type, String account_num)
	{
		try
		{
			keyword.click("xpath", "//a[contains(text(),'Mini Statement')]", statement_type);
			keyword.select_dropdown("xpath", "//select[@name='accountno']", account_num);
			keyword.click("xpath", "//input[@name='AccSubmit']", "Submit");
			String bodydetail = keyword.getText("tagname", "body");		
			if(bodydetail.contains("Last Three Transaction Details for Account No:"))
			{
				Reporter.log("Text displayed correctly",true);
				
			}
			else
			{
				Reporter.log("Text not displayed correctly",true);
			}
		}catch(Exception e)
		{
			Reporter.log("Exception in check_account scenarios",true);
		}
	}
	
	public void checkbox_selection(String url)
	{
		try
		{
			keyword.Open(url);
			keyword.click("xpath", "//a[@class='dropdown-toggle']", "dropdown-toggle");
			keyword.click("xpath", "//a[contains(text(),'Radio & Checkbox Demo')]", "Radio & Checkbox Demo");
			keyword.click("xpath", "//input[@id='vfb-7-2']", "vfb-7-2");
			keyword.click("xpath", "//input[@id='vfb-6-0']", "vfb-6-0");
			keyword.click("xpath", "//input[@id='vfb-6-1']", "vfb-6-1");
			keyword.click("xpath", "//input[@id='vfb-6-2']", "vfb-6-2");

		}catch(Exception e)
		{
			Reporter.log("Exception in checkbox_selection scenarios",true);
		}
	}

		
	public void upload_file(String urlnew1)
	{
		try
		{
			keyword.Open(urlnew1);
			keyword.entertext("xpath", "//input[@id='uploadfile_0']", "/Users/mahattam/Downloads/Tavleen_Cover_Letter.pdf");
			keyword.click("xpath", "//input[@id='terms']", "terms");
			keyword.click("xpath", "//button[@id='submitbutton']", "submitbutton");

		}catch(Exception e)
		{
			Reporter.log("Exception in upload_file scenarios",true);
		}

	}
	
	public void new_customer_create(String customer_name,String gender)
	{
//		3. select radiobutton
//		4.enter date of birth
//		5. enter address
//		6. enter city
//		7.enter state
//		8. enter pin number
//		9. enter telephone
//		10. enter email
//		11. click on submit	
		String xpath_value;
		keyword.click("xpath", "//a[contains(text(),'New Customer')]", "CustomerLink");
		keyword.entertext("xpath", "//input[@name='name']", customer_name);
		if (gender == "male")
		{
			xpath_value="//input[@name='rad1'][1]";
			
		}else
		{
			xpath_value="//input[@name='rad1'][2]";
		}
		keyword.click("xpath", xpath_value, gender);
		
	}
		
		
		public void AddCustomerDone(String telecomurl,String firstname,String lastname,String email,String address, String mobile)
		
		{
			try
			{
				keyword.Open(telecomurl);
				
				
				keyword.click("xpath","//div[@class='flex-item left']//div//a[contains(text(),'Add Customer')]","addcustomerlink");
				keyword.click("xpath","//label[contains(text(),'Done')]","done");
		
				keyword.entertext("xpath","//input[@id='fname']", firstname);
				keyword.entertext("xpath","//input[@id='lname']", lastname);
				keyword.entertext("xpath","//input[@id='email']", email);
				keyword.entertext("xpath","//textarea[@id='message']", address);
				keyword.entertext("xpath","//input[@id='telephoneno']", mobile);
				
				keyword.click("xpath","//input[@name='submit']","submit");
				
//				if(positive scenarion)
//				{
//					System.out.println("Customer added successfully");
//					
//				}else if(email is invalid)
//				{
//					System.out.println("Email value is invalid");
//				}else if(mobile is invalid)
//				{
//					System.out.println("mobile value is invalid");
//				}
					
			}
			catch(Exception e)
			{
				System.out.print("Add customer unsuccessful");
			}
		
		}
		
	}
	

