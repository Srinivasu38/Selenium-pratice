package june11;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
	Logger log;
	@Test
	public void verifylogin() throws Throwable {
		log=Logger.getLogger(getClass());
		PropertyConfigurator.configure("D:\\software\\seleniumproject\\Selenium_practise\\Log4j.properties");
		driver=new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\P SRINIVASU\\Desktop\\dd\\chromedriver.exe");
		log.info("launching chrome browser");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		log.info(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
		log.info("Enter username");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		log.info("Enter password");
		driver.findElement(By.cssSelector("#btnLogin")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		log.info("click on login button");
		String expected ="dashboard";
		String actual=driver.getCurrentUrl(); 
		if(actual.contains(expected))
		{
			Reporter.log("login success:::"+expected+"  "+actual,true);
			log.info("login success:::"+expected+"  "+actual);
		}
		else
		{
			String message=driver.findElement(By.cssSelector("#spanMessage")).getText();
			Reporter.log(message+" "+"login fail::"+expected+"  "+actual,true);
			log.info(message+" "+"login fail::"+expected+" "+actual);
		}
		Thread.sleep(5000);
		driver.close();
		log.info("close application browser");
	}

}
