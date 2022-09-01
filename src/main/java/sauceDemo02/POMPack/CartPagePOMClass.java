package sauceDemo02.POMPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPagePOMClass 
{
	private WebDriver driver;
	
	
	//continue shopping
	@FindBy(xpath="continue-shopping")
	private WebElement contiueshoppingButton;
	
	public void clickcontiueshoppingButton()
	{
		contiueshoppingButton.click();
	}
	
	//checkoutbutton
	@FindBy(xpath="//button[@id='checkout']")
	private WebElement checkoutButton;
	
	public void clickcheckoutButton()
	{
		checkoutButton.click();
	}
	
	//remove button
		@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")
		private WebElement removeButton;
		
		public void clickremovButton()
		{
			removeButton.click();
		}
	
	
	public CartPagePOMClass(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements( driver,this);
		
	}
	
	

}
