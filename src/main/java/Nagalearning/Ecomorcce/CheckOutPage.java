package Nagalearning.Ecomorcce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Nagalearning.AbstaractComponets.AbstaractComponents;

public class CheckOutPage extends AbstaractComponents {

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submitorder;
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']//button")
	List<WebElement> countries;
By dropdownlists=By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button");
	public void selectCountry(String usercountry,String disiredCountry)
	{
		country.sendKeys(usercountry);
	waitForelementToBeAppear(dropdownlists);
	for(WebElement country : countries)
	 {
		 if(country.getText().equalsIgnoreCase(disiredCountry))
		 {
			 country.click();
		 }
	 }
	}
public PlaceOrderPage sumbit()
{
	submitorder.click();
	PlaceOrderPage OrderPage=new PlaceOrderPage(driver);
	return OrderPage;
}
	
}
