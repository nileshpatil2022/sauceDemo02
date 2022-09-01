package sauceDemo02.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOMClass 
{
WebDriver driver;
	
	//2&3-webelement find & perform action 
	//1.-username
	@FindBy(xpath="//input[@id='user-name']")
	 private WebElement username;
	
	public void senKeysUsername()
	{
		username.sendKeys("standard_user");
	}
	
	//2.passward
	
	 @FindBy(xpath="//input[@id='password']")
	 
	   private WebElement passward;
	 
	 public void senkeysPassward()
	 {
		 passward.sendKeys("secret_sauce");
	 }
	
	//3.loginclick
	 @FindBy(xpath="//input[@id='login-button']")
	      private WebElement loginButtonClick;
	 
	
	    public void clickLoginButton()
	    {
	    	loginButtonClick.click();	
	    }
	
	
	//4-constructor defines
	    public LoginPOMClass(WebDriver driver)
	    {
	    	 this.driver=driver;
	    	 
	    	 PageFactory.initElements( driver,this);
	    }


}
