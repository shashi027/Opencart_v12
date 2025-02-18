package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homepage;
import pageObjects.loginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	void verify_login()
	{
		logger.info("*****Starting TC002_LoginTest*****");
		try
		{
		homepage hp=new homepage(d);
		hp.clickMyaccount();
		hp.clickLogin();
		
		loginPage lp=new loginPage(d);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage mc=new MyAccountPage(d);
		boolean targetpage = mc.isMyAccPageExist();
		Assert.assertEquals(targetpage, true,"Test Failed");
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****Finished TC002_LoginTest*****");
	}

}
