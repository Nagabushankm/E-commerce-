package Nagalearning.Tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Nagalearning.Ecomorcce.CheckOutPage;
import Nagalearning.Ecomorcce.LoginPage;
import Nagalearning.Ecomorcce.PlaceOrderPage;
import Nagalearning.Ecomorcce.ProcutsCart;
import Nagalearning.Ecomorcce.ProductCatlog;

public class TestCase1 {

	public static void main(String[] args) {
		String Productname="ZARA COAT 3";
		String desiredCounty="india";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\U1118763\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage LogintoApp=new LoginPage(driver);
		LogintoApp.goTo();
		ProductCatlog ProductCatlog=LogintoApp.LoginToApplication("nagu@gmail.com", "Nagu@3009");
		List<WebElement>product=ProductCatlog.getProductlist();
		ProductCatlog.addProductToCart(Productname);
		ProcutsCart cartlist= ProductCatlog.goToCart();
		Boolean match=cartlist.userProductMatch(Productname);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage=cartlist.checkOut();
		checkoutpage.selectCountry("india",desiredCounty);
		PlaceOrderPage odredrpage=checkoutpage.sumbit();
		String Confirmmessage=odredrpage.conformationmessage();
		 Assert.assertTrue(Confirmmessage.equalsIgnoreCase("Thankyou for the order."));
		 driver.close();
		
	}
}
	