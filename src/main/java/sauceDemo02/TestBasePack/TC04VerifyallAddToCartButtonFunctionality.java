package sauceDemo02.TestBasePack;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sauceDemo02.POMPack.HomePOMClass;
import sauceDemo02.POMPack.LoginPOMClass;

public class TC04VerifyallAddToCartButtonFunctionality extends TestBaseClass
{
	
    @Test 
	public void allProductAddToCart() 
	{
		//click all button
		
		HomePOMClass hm=new HomePOMClass(driver);
		
		hm.clickalladdToCartButton();
		
		//validation
		String ExpectedResult="6";
		
		//actual result
		 String actualResult= hm.getTextFromAddToCart();
		 
		 Assert.assertEquals(actualResult, ExpectedResult);
	}
		
		
	}

