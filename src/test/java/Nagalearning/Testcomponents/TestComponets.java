package Nagalearning.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Nagalearning.Ecomorcce.LoginPage;

public class TestComponets {

	public WebDriver driver;
	public LoginPage LogintoApp;

	public void intializeTheBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "//src/main//java//Nagalearning//resources//GlobalData.properties");
		prop.load(fs);
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\U1118763\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", "edge.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod(alwaysRun=true)
	public LoginPage LunchApplication() throws IOException {
		intializeTheBrowser();
		LogintoApp = new LoginPage(driver);
		LogintoApp.goTo();
		return LogintoApp;

	}

	@AfterMethod
	public void CloseApplication() {
		driver.close();
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		//convert the json into string
		String jsoncontent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		
		//convert string to hashmapp (we have to has the dependency  jackson databind)
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>>	data =mapper.readValue(jsoncontent,  new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
	
	public String getScreenshot(String TestcaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png";
		
		
	}
	
}
