package Nagalearning.Tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Nagalearning.Ecomorcce.CheckOutPage;
import Nagalearning.Ecomorcce.LoginPage;
import Nagalearning.Ecomorcce.OrderPage;
import Nagalearning.Ecomorcce.PlaceOrderPage;
import Nagalearning.Ecomorcce.ProcutsCart;
import Nagalearning.Ecomorcce.ProductCatlog;
import Nagalearning.Testcomponents.TestComponets;

public class SubmitOrder extends TestComponets {
	String Productname = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"purchase"})
	public void SubmitOrder(HashMap<String,String> input)
	{
		
		String desiredCounty = "india";
		ProductCatlog ProductCatlog = LogintoApp.LoginToApplication(input.get("emailid"), input.get("password"));
		List<WebElement> product = ProductCatlog.getProductlist();
		ProductCatlog.addProductToCart(input.get("produtName"));
		ProcutsCart cartlist = ProductCatlog.goToCart();
		Boolean match = cartlist.userProductMatch(input.get("produtName"));
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartlist.checkOut();
		checkoutpage.selectCountry("india", desiredCounty);
		PlaceOrderPage odredrpage = checkoutpage.sumbit();
		String Confirmmessage = odredrpage.conformationmessage();
		Assert.assertTrue(Confirmmessage.equalsIgnoreCase("Thankyou for the order."));

	}
	
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void verfiyOrderDetails()
	{
		ProductCatlog ProductCatlog = LogintoApp.LoginToApplication("nagu@gmail.com", "Nagu@3009");
		OrderPage orderspage=ProductCatlog.goToOrders();
		Boolean match =orderspage.verifyOrderDetails(Productname);
		Assert.assertTrue(match);
	}
	//by using hashmap
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String, String>> data=	getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Nagalearning\\Data\\PurchaseOrder.json");
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("emailid", "nagu@gmail.com");
//		map.put("password", "Nagu@3009");
//		map.put("produtName", "ZARA COAT 3");
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("emailid", "nagu@gmail.com");
//		map1.put("password", "Nagu@3009");
//		map1.put("produtName", "ZARA COAT 3");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
	
	
	
	
	
	//by using multidimension array
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][] {{"nagu@gmail.com","Nagu@3009","ZARA COAT 3"},{"nagu@gmail.com","Nagu@3009","ZARA COAT 3"}};
//	}
//	
	
}
