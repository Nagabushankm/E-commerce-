package Nagalearning.Ecomorcce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Nagalearning.AbstaractComponets.AbstaractComponents;

public class ProductCatlog extends AbstaractComponents {

	WebDriver driver; 
	public ProductCatlog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;

	
	By prodbylist=By.cssSelector(".mb-3");
	By addTocart=By.xpath("//div[@class='card-body']//button[2]");
	By toastContainer=By.cssSelector("#toast-container");
	By spinner=By.cssSelector(".ng-animating");
	public List<WebElement> getProductlist()
	{
		return products;
	}
	/*WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(Productname)).findFirst().orElse(null);
	prod.findElement(By.xpath("//div[@class='card-body']//button[2]")).click();*/
	public WebElement getProductByName(String Productname)
	{
		waitForelementToBeAppear(prodbylist);
		WebElement prod=getProductlist().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(Productname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String Productname)
	{
		WebElement prod=getProductByName(Productname);
		prod.findElement(addTocart).click();
		waitForelementToBeAppear(toastContainer);
		waitForelementToBeDisAppear(spinner);
	}

}
