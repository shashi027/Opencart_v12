package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homepage;
import pageObjects.registerPage;
import testBase.BaseClass;

public class TC001_Account_Registeration extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_acc_reg()
	{
		logger.info("*****Starting TC001_Account_Registeration*******");
		try
		{
		homepage hp=new homepage(d);
		hp.clickMyaccount();
		logger.info("Clicked on my account");
		hp.clickRegister();
		logger.info("Clicked on register");
		
		registerPage rp=new registerPage(d);
		
		logger.info("providing customer info");
		
		rp.setFirstname(randomeString().toUpperCase());
		rp.setLastname(randomeString().toUpperCase());
		rp.setEmail(randomeString()+"@gmail.com");
		rp.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		
		rp.checkpolicy();
		rp.clickContinue();
		
		logger.info("Validating exp message");
		String ConMsg=rp.getConfirmationMsg();
		
		if(ConMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed");
			logger.debug("debug logs");
			Assert.fail();
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}

}
