package week5.day1.assignment;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseLead {
	ChromeDriver driver;
	@BeforeMethod
	public void login() {
		// TODO Auto-generated method stub
		
		//Chrome Driver needs to be downloaded and set to the path
		WebDriverManager.chromedriver().setup();
		
		// Launch the chrome browser
		driver=new ChromeDriver();
		
		// Load the url
		driver.get("http://leaftaps.com/opentaps/control/login"); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Maximize the screen
		driver.manage().window().maximize();	
		
		//Find the user name and type the value
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//Find the password and type the value
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Find the login button and click
		driver.findElementByClassName("decorativeSubmit").click();

		//Verify that you are logged in
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		
		//Click link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
			
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
