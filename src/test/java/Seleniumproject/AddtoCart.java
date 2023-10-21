package Seleniumproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddtoCart {
	
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
	public void SearchTest() throws InterruptedException
	{
		SoftAssert softAssert = new SoftAssert(); 
		driver.findElement(By.xpath("//a[@data-product_id='163']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='View Basket']")).click();
		driver.get("https://practice.automationtesting.in/basket/");
		
		WebElement proceed=driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/checkout/']"));
		
		String Actualtext=proceed.getText();
		
		String Expectedtext="Proceed to Checkout";
		softAssert.assertEquals(Actualtext,Expectedtext);
		System.out.println(Actualtext);
		

		
		
	}
	@AfterSuite
	public void teardown()
	{
		
		driver.close();
		 
	}
	}	


