package sauceDemo02.TestBasePack;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	
	driver.get("https://www.saucedemo.com/");
  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
  TakeScreenShot.screenshot(driver);
	
	LoginPOMClass login=new LoginPOMClass(driver);
	
	login.senKeysUsername();
	System.out.println("Username is entered");
	
	login.senkeysPassward();
	System.out.println("Password is Enterd");
	
	login.clickLoginButton();
	System.out.println("Click on Login Button");
	 TakeScreenShot.screenshot(driver);
	
}

@AfterMethod()
 public void tearDown()
 {
 driver.quit();
 
 System.out.println("Browser is Closed");
 }


}
