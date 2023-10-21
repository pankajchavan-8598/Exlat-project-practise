package Seleniumproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.automationtesting.in/my-account/");
		Thread.sleep(4000);
	}
   @Test
	public void correct_login()
	{
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("pankajchavan8598@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Pankaj@1012");
		WebElement signInBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		signInBtn.click();
		
		WebElement signIn=driver.findElement(By.xpath("//a[text()='Dashboard']"));
		String Actualtext=signIn.getText();
		System.out.println(Actualtext);		
		String ExpectedText="Dashboard";
		
		SoftAssert softAssert = new SoftAssert(); 
		softAssert.assertEquals(ExpectedText,Actualtext);
		 
	}
    @Test
    
    public void Incorrect_login2()
	{
		WebElement username=driver.findElement(By.xpath("//input[@name='username']"));
		username.sendKeys("pankajchavan8598@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("$1234");
		WebElement signInBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		signInBtn.click();
		
		WebElement signIn=driver.findElement(By.xpath("//strong[contains(text(),'Error:')]"));
		SoftAssert softAssert = new SoftAssert(); 
		String Actualtext=signIn.getText();
		System.out.println(Actualtext);		
		String Expectedtext="Error:";
		softAssert.assertEquals(Expectedtext,Actualtext);
		 
	}
   
   
	@AfterMethod
	public void teardown()
	{
	
		driver.close();
	}
	

}

	




