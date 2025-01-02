package Nagalearning.Ecomorcce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nagalearning.AbstaractComponets.AbstaractComponents;


public class ProcutsCart extends AbstaractComponents{
	WebDriver driver; 
	public ProcutsCart(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='cart'] //h3")
	List<WebElement> produtsnamme;
	@FindBy(xpath="//li[@class='totalRow'] //button")
	WebElement Checkoutpage;
	
	@FindBy(xpath="//li[@class='totalRow'] //button")
	WebElement elementclickable;
	
	public boolean userProductMatch(String Productname)
	{
		
		boolean match=produtsnamme.stream().anyMatch(avilableproducts->avilableproducts.getText().equals(Productname));
		return match;

		
	}
	public CheckOutPage checkOut()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		elementsToBeClickable(elementclickable);
		Checkoutpage.click();
		CheckOutPage CheckOutPage=new CheckOutPage(driver);
		return CheckOutPage;
				
	}
	

}
