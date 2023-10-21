package Seleniumproject;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SearchProduct {
	
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.automationtesting.in/");
		Thread.sleep(4000);
		
		
	}
	@Test
	public void search()
	{
		SoftAssert softAssert = new SoftAssert(); 
		
		driver.findElement(By.xpath("//a[text()='Shop']")).click();
		String Actualtitle=driver.getTitle();
		System.out.println( Actualtitle);
		
		String Expectedtitle="Automation Practice Site";
		softAssert.assertEquals(Expectedtitle,Actualtitle);
	
	}
	
	@AfterSuite
	public void teardown()
	{
		
		driver.close();
		 
	}
	}



