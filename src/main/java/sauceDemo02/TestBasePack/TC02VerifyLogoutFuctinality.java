package sauceDemo02.TestBasePack;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import sauceDemo02.POMPack.HomePOMClass;



public class TC02VerifyLogoutFuctinality extends TestBaseClass
{
	
	
	@Test
	public void verifyLogOut()
	{
		
		
		//homepage settingButton and LogoutButton
		HomePOMClass lg=new HomePOMClass(driver);
		
		lg.clicksettingButton();
		System.out.println("setting button clicked");
		
		lg.clickLogOutButton();
		System.out.println("Logout Button is clicked");
		
		
		String ExpectedResult="Swag Labs";
		
		String ActualResult=driver.getTitle();
		
		
		Assert.assertEquals(ActualResult, ExpectedResult);
		// test.log(Status.INFO, "test case 02 Passed");
	}
		
		
	

}
