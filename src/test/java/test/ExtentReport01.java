package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport01 
{
	public static void main(String[] args) 
	{
		
		ExtentHtmlReporter reportHtml=new ExtentHtmlReporter("report123.html");
	    ExtentReports extent =new ExtentReports();
	               extent.attachReporter(reportHtml);
	               
	    ExtentTest test=extent.createTest("Angle one","login functionality test");          
	               
	    
	    
	    System.setProperty("webdriver.chrome.driver",
	       				"./DriverFolder/chromedriver.exe");
	       		

	       		WebDriver driver= new ChromeDriver();
	       		
	       		driver.manage().window().maximize();
	     test.log(Status.INFO, "Test case Start");
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
	    
	    test.log(Status.INFO, "test case Finished");
	    driver.close();
	    driver.quit();
	
	    extent.flush();
	
	
	
	
	}

}
