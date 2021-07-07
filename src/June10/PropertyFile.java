package June10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PropertyFile {
	WebDriver driver;
	Properties config;

	@BeforeTest
	public void setup() throws Throwable
	{
		config= new Properties();
		config.load(new FileInputStream("D:\\software\\seleniumproject\\Selenium_practise\\OR.properties"));
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\P SRINIVASU\\Desktop\\dd\\chromedriver.exe");
		if(config.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			
			driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(config.getProperty("url"));
			Reporter.log("Excuting on chrome browser",true);
		}
		else if(config.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			
			driver=new FirefoxDriver();
			driver.get(config.getProperty("url"));
			Reporter.log("Excuting on firebox browser",true);
	}
		else
		{
			Reporter.log("browseer value is not macthing",true);
		}
		
	}
	@Test
	public void verifylogin() throws Throwable
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(config.getProperty("objReset"))));
		driver.findElement(By.xpath(config.getProperty("objReset"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(config.getProperty("objusername"))));
		driver.findElement(By.xpath(config.getProperty("objusername"))).sendKeys("admin");
		driver.findElement(By.xpath(config.getProperty("objpassword"))).sendKeys("master");
		driver.findElement(By.xpath(config.getProperty("objlogin"))).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.titleContains("Dashboard « Stock Accounting"));
		String expected="Dashboard « Stock Accounting";
		String actual=driver.getTitle();
		if(expected.equalsIgnoreCase(actual))
		{
	
			Reporter.log("login sucess::"+expected+"  "+actual,true);
			
		}
		else
		{
			Reporter.log("login fail::"+expected+"  "+actual,true);
		}
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
	

}
