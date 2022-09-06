package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportsDemo02 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter("reports.html");
		
		ExtentReports extent=new ExtentReports();
		
		extent.attachReporter(htmlReport);
		    
	   ExtentTest test= extent.createTest("sauceDemoLogin", "user is able login");
		      
	    System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
	
		 driver= new ChromeDriver();
		
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
		 
		 driver.close();
		 driver.quit();
		 
		 test.log(Status.INFO, "Test case Stop");
		 
		 extent.flush();
		      
		
		
	}
	

}
