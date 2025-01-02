package Nagalearning.Ecomorcce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nagalearning.AbstaractComponets.AbstaractComponents;

public class PlaceOrderPage extends AbstaractComponents {
	WebDriver driver;
	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement Confirmmessage;
	
	public String conformationmessage()
	{
		String meessage =Confirmmessage.getText();
		return meessage;
	}
}
