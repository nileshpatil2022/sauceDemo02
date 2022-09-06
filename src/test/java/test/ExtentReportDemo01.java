package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo01 {
	static WebDriver driver;
	public static void main(String[] args) 
	{
		
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter("extentReport.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		
		
		ExtentTest test = extent.createTest("Google Test", "To check the Search Functionality");
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\LENOVO\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
	
		 driver= new ChromeDriver();
		
	      test.log(Status.INFO, "Test case Start");
		
		 
		driver.get("https://www.google.com");
		
		test.pass("navigate to the google search page");
	     WebElement text= driver.findElement(By.name("q"));
	     text.sendKeys("automation");
	     
	     test.pass("enered text in Search tab");
	
	     WebElement text1=driver.findElement(By.name("btnK"));
	 	
	     text.click();
	     test.pass("Clicked on search button");
	
	     driver.close();
	     
	     driver.quit();
	     test.pass("browser is closed");
	     test.info("test completed");
	     
	     extent.flush();
	
	
	
	
	}

}
