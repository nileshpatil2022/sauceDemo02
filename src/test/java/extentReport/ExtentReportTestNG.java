package extentReport;

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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTestNG 
{
	private ExtentHtmlReporter report;
	private ExtentReports extent;
	private WebDriver driver;
	private ExtentTest test;
	
	@BeforeSuite
	public void setUp()
	{
		 report=new ExtentHtmlReporter("Reports01.html");
		 extent=new ExtentReports();
		    extent.attachReporter(report);
	test= extent.createTest("angleOne","login functionality check");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver",
   				"./DriverFolder/chromedriver.exe");
   		 driver= new ChromeDriver();
   		driver.manage().window().maximize();
	}
	
	@Test
	public void test()
	{
		test.log(Status.INFO, "Test case start");
		driver.get("https://trade.angelbroking.com/Login");
		WebElement EmailID=driver.findElement(By.xpath("//input[@id='txtUserID']"));
		EmailID.sendKeys("N407241");
		test.pass("entered username"); 
		
		 WebElement passward    = driver.findElement(By.xpath("//input[@id='txtTradingPassword']"));
		 passward.sendKeys("Test@2022");
	    test.pass("entered password"); 
	    
	    
	    WebElement signup=driver.findElement(By.xpath("//a[@id='loginBtn']"));
		   signup.click();
	    test.pass("clicked on signup button");
		
	}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		driver.quit();
		test.pass("test case finished");
	test.log(Status.INFO, "test case Finished");
		
	}
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
		
	}

}
