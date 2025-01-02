package Nagalearning.AbstaractComponets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Nagalearning.Ecomorcce.OrderPage;
import Nagalearning.Ecomorcce.ProcutsCart;
import dev.failsafe.internal.util.Assert;

public class AbstaractComponents {

	WebDriver driver;
	public AbstaractComponents(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderbutton;
	
	//button[@routerlink='/dashboard/myorders']
	public void waitForelementToBeAppear(By findby)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitForwebelementToBeAppear(WebElement findby)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(findby));
	}
	public void waitForelementToBeDisAppear(By findby)
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(findby));
	}
	public void elementsToBeClickable(WebElement findby )
	{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable((findby)));
	}
  
	  public ProcutsCart goToCart()
	   {
		   cartButton.click();
		   ProcutsCart cartlist=new ProcutsCart(driver);
		   return cartlist;
	   }
	  public OrderPage goToOrders()
	   {
		  orderbutton.click();
		   OrderPage orderlist=new OrderPage(driver);
		   return orderlist;
	   }
	
}
