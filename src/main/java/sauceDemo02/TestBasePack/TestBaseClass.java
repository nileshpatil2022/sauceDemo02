package sauceDemo02.TestBasePack;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import sauceDemo02.POMPack.LoginPOMClass;
import sauceDemo02.UtilityPack.TakeScreenShot;




public class TestBaseClass 
{
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(String BrowserName) throws IOException
	{
		
		
	if(BrowserName.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver",
			"./DriverFolder/chromedriver.exe");
	  driver= new ChromeDriver();
	  
	}
	else
	{
		System.setProperty("webdriver.gecko.driver",
				"./DriverFolder/geckodriver.exe");
		  driver= new ChromeDriver();	
	}
	driver.manage().window().maximize();
	//test.log(Status.INFO, "test case start");
	
	driver.get("https://www.saucedemo.com/");
	//test.pass("navigate to home page");
  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
  TakeScreenShot.screenshot(driver);
  // test.pass("sreenshot was taken");
	
	LoginPOMClass login=new LoginPOMClass(driver);
	
	login.senKeysUsername();
	//test.pass("Username is entered");
	
	login.senkeysPassward();
	//test.pass("Password is Enterd");
	
	login.clickLoginButton();
	//test.pass("Click on Login Button");
	 TakeScreenShot.screenshot(driver);
	 //test.pass("sreenshot was taken");
	
}

@AfterMethod()
 public void tearDown()
 {
 driver.quit();
 
 
 }



}
