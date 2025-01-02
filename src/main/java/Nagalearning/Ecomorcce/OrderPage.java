package Nagalearning.Ecomorcce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nagalearning.AbstaractComponets.AbstaractComponents;

public class OrderPage extends AbstaractComponents{

	WebDriver driver; 
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(xpath="//tbody //tr //td[2]")
	List<WebElement> orderedproductlist;


	public Boolean verifyOrderDetails(String Productname)
	{
		
		Boolean match=orderedproductlist.stream().anyMatch(product->product.getText().equalsIgnoreCase(Productname));
		return match;
	}
	
	

}
