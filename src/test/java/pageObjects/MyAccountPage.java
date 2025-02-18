package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends basepage{

	public MyAccountPage(WebDriver d) 
	
	{
		super(d);
		
	}

	
	@FindBy(xpath="//div[@id='content']//h2[text()='My Account']")
	WebElement MsgHeading;
	
	@FindBy(xpath="//aside[@id=\"column-right\"]//a[normalize-space()='Logout']")
	WebElement lnkLogout;
	
	
	public boolean isMyAccPageExist()
	{
		try
		{
		return MsgHeading.isDisplayed();
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
	public void clicklogout()
	{
		lnkLogout.click();
	}
	
}
