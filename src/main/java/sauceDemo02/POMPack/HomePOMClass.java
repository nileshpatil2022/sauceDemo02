package sauceDemo02.POMPack;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePOMClass
{
	private WebDriver driver;
private Select s;
	
	//2.find webelement
	
	
	//click on bag product
	@FindBy(xpath="(//button[text()='Add to cart'])[1]")
	  private WebElement bagProduct;
	
	public void clickonBagProduct()
	{
		bagProduct.click();
	}
	
	//click add to cart button
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement addToCartBotton1;
	
	public void clickonBagProductButton()
	{
		addToCartBotton1.click();
	}
	
	
	
	
	
	//validation add to cart button
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	private WebElement addToCartBotton;
	
	public String getTextFromAddToCart()
	{
		
	String count=addToCartBotton.getText();
		return count;
	}
	
	
	
	
	//number of 6 product add to cart
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	 private List<WebElement> allAddToCartButton;
	
	public void clickalladdToCartButton()
	{
		for(WebElement k:allAddToCartButton)
		{
			k.click();
			
		}
	}
	
	//filter apply
	@FindBy(xpath="//select[@class='product_sort_container']")
	    private WebElement dropDownSelect;
	
	public void selectdropDownSelect()
	{
		dropDownSelect.click();
		
		s.selectByVisibleText("Price (high to low)");	
	}
	
	
	//validation about filter
	
	@FindBy(xpath="//option[text()='Price (high to low)']")
	       private WebElement optionselect;
	
	public String getOptionSelect()
	{
		String op=optionselect.getText();
		return op;
	}
	
	//click setting button
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	  private WebElement settingButton;
	
	public void clicksettingButton()
	{
		settingButton.click();
	}
	
	//click logout button
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	 private WebElement logoutButton;
	
	public void clickLogOutButton()
	{
		logoutButton.click();
	}
	
	
	public HomePOMClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
		//select class
		s=new Select(dropDownSelect);
		
	}
	
	
	

}
