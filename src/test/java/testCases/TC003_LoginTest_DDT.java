package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyAccountPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginTest_DDT extends BaseClass{

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		
		try
		{
		homepage hp=new homepage(d);
		hp.clickMyaccount();
		hp.clickLogin();
		
		loginPage lp=new loginPage(d);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		
		MyAccountPage map=new MyAccountPage(d);
		boolean tarpage = map.isMyAccPageExist();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(tarpage==true)
			{
				map.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);

			}
				
			
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(tarpage==true)
			{
				map.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
			
		}
		
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
	}

}
