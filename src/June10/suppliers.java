package June10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class suppliers {
	 WebDriver driver;
	@Test
	public  void setup() throws Throwable {
	driver= new ChromeDriver();
	driver.get("http://projects.qedgetech.com/webapp");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[@id='btnreset']")).click();
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("master");
	driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//body/div[2]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]")).click();
	}

}
