package sauceDemo02.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyPagePOMClass 
{
	private WebDriver driver;
	
	
	//first name element 
	@FindBy(xpath="//input[@id='first-name']")
    private WebElement firstName;
	
	public void sendFirstNmae()
	{
		firstName.sendKeys("nilesh");
	}
	
	//last name
	@FindBy(xpath="//input[@id='last-name']")
    private WebElement lastName;
	
	public void sendLastNmae()
	{
		lastName.sendKeys("patil");
	}
	
	
	   //pin code
		@FindBy(xpath="//input[@id='postal-code']")
	    private WebElement pinCode;
		
		public void sendPinCode()
		{
			pinCode.sendKeys("416214");
		}
	
		

		   //continue button
			@FindBy(xpath="//input[@id='continue']")
		    private WebElement continueButton;
			
			public void clickContinueButton()
			{
				continueButton.click();	
			}
		
	        
			//cancel button
			@FindBy(xpath="//button[@id='cancel']")
		    private WebElement cancelButton;
			
			public void clickCancelButton()
			{
				cancelButton.click();	
			}
			
			public BuyPagePOMClass(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements( driver,this);
				
				
			}
	
	
			
			
			
			
}
