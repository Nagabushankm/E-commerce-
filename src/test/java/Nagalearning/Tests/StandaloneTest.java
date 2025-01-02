package Nagalearning.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandaloneTest {

	public static void main(String[] args) {
		String Productname="ZARA COAT 3";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\U1118763\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("userEmail")).sendKeys("nagu@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Nagu@3009");
		driver.findElement(By.id("login")).click();
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(Productname)).findFirst().orElse(null);
		prod.findElement(By.xpath("//div[@class='card-body']//button[2]")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement>produtsnamme=driver.findElements(By.xpath("//div[@class='cart'] //h3"));
		boolean match=produtsnamme.stream().anyMatch(avilableproducts->avilableproducts.getText().equals(Productname));
		Assert.assertTrue(match);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='totalRow'] //button")));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button")));
	List<WebElement> countries=driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']//button"));
	 for(WebElement country : countries)
	 {
		 if(country.getText().equalsIgnoreCase("india"))
		 {
			 country.click();
		 }
	 }
	driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
	
	String Confirmmessage=driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
	 Assert.assertTrue(Confirmmessage.equalsIgnoreCase("Thankyou for the order."));
	 driver.close();
	}
}
	