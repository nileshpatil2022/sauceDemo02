package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportTestNG 
{
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	
	private static WebDriver driver;
	private static ExtentTest test;
	@BeforeSuite
	public void setUP()
	{
		  htmlReporter = new ExtentHtmlReporter("extent2.html");
	         extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);	
	}
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
	
		 driver= new ChromeDriver();
		
	}

	@Test
	public void test() throws IOException
	{
		  test= extent.createTest("sauceDemoLogin", "user is able login");
        test.log(Status.INFO, "Test case start");
		
		driver.get("https://www.saucedemo.com/");
		
		test.pass("navigate to sauce demo lagin page");
		WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		 test.pass("entered username");         
		WebElement passward=driver.findElement(By.xpath("//input[@id='password']"));
		passward.sendKeys("secret_sauce");
		 test.pass("entered password");     
		WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
		login.click();
		 test.pass("clicked on login button");
		
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.close();
		 driver.quit();
		 
		 test.log(Status.INFO, "Test case Stop");
	}
	@AfterSuite
	public void tearDown()
	{
		 extent.flush();
	}
}
