package Nagalearning.Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
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
import org.testng.annotations.Test;

import Nagalearning.Ecomorcce.CheckOutPage;
import Nagalearning.Ecomorcce.LoginPage;
import Nagalearning.Ecomorcce.PlaceOrderPage;
import Nagalearning.Ecomorcce.ProcutsCart;
import Nagalearning.Ecomorcce.ProductCatlog;
import Nagalearning.Testcomponents.TestComponets;

public class Errorvalidation extends TestComponets {

	@Test
	public void loginErrorValidation() throws IOException {
		String Productname = "ZARA COAT 3";
		String desiredCounty = "india";
		ProductCatlog ProductCatlog = LogintoApp.LoginToApplication("nagu@gmail.com", "Nagu@30s09");
		Assert.assertEquals("Incorrect email or te password.", LogintoApp.LoginValidationError());
	}
	@Test
	public void productValidation() throws IOException {
		String Productname = "ZARA COAT 3";
		String desiredCounty = "india";
		ProductCatlog ProductCatlog = LogintoApp.LoginToApplication("nagu@gmail.com", "Nagu@3009");
		List<WebElement> product = ProductCatlog.getProductlist();
		ProductCatlog.addProductToCart(Productname);
		ProcutsCart cartlist = ProductCatlog.goToCart();
		Boolean match = cartlist.userProductMatch("ZARA COAT 33");
		Assert.assertTrue(match);
	//new line added 
		//added

	}
}

