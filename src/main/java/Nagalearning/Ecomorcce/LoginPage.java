package Nagalearning.Ecomorcce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nagalearning.AbstaractComponets.AbstaractComponents;

public class LoginPage extends AbstaractComponents {

	WebDriver driver; 
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userName=driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement passWord;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
public ProductCatlog LoginToApplication(String emailid,String password)
{
	userName.sendKeys(emailid);
	passWord.sendKeys(password);
	login.click();
	ProductCatlog ProductCatlog=new ProductCatlog(driver);
	return ProductCatlog;
}

public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");
}
	public String LoginValidationError()
	{
		waitForwebelementToBeAppear(errormessage);
		return errormessage.getText();
		
	}
}
