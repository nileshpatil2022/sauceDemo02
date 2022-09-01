package sauceDemo02.UtilityPack;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShot 
{
	public static void screenshot(WebDriver driver) throws IOException
	{
		Date d=new Date();
		SimpleDateFormat d1=new SimpleDateFormat("dd-MM-yy&hh-mm-ss");
		String time=d1.format(d);
		String timesstag=time.toString().replace("-", "").replace(":", "").replace("&", "");
		 
		TakesScreenshot sc=(TakesScreenshot) driver;
		File sourse=sc.getScreenshotAs(OutputType.FILE);
		File location=new File("./ScreenshotFolder/image"+timesstag+".jpg");
	    FileHandler.copy(sourse, location);
	
		
	}

}
