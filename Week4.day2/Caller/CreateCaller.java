package week4.day2.caller.assignment;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCaller {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver    ().setup();
		ChromeDriver driver = new ChromeDriver();

		// Load the url
		driver.get("https://dev103117.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		

		// Switch to iframe
		driver.switchTo().frame("gsft_main");
		// User id
		driver.findElement(By.id("user_name")).sendKeys("admin");
		// password
		driver.findElement(By.id("user_password")).sendKeys("India@123");
		// Click login
		driver.findElement(By.id("sysverb_login")).click();

		// Wait for the element to visible
		// WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		// WebElement eleIncident =
		// driver.findElement(By.xpath("//span[text()='Incident'][1]"));

		// Find filter search box and enter caller and click enter
		WebElement filterbox = driver.findElement(By.xpath("//input[@id='filter']"));
		filterbox.sendKeys("caller", Keys.ENTER);
		
		// Click on Open proposals
		driver.findElement(By.xpath("//div[text()='Callers']")).click();
		
		// Switch to iframe
		driver.switchTo().frame("gsft_main");

		
		//Click on new
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();

	
		
		//Find First name and pass value
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("sailesh");
		//Find Last name and pass value
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("sai");
		
		//Find title lookup and click 
		driver.findElement(By.id("lookup.sys_user.title")).click();
		
		//Get window handles
		Set<String> winhand = driver.getWindowHandles();
		
		// Get the window handles in a list
		List<String> titlewin = new ArrayList<String>(winhand);
		
		// Switch to second window
			driver.switchTo().window(titlewin.get(1));
			System.out.println("2nd Window Title: " + driver.getTitle());
		
			//click on the value from the list
			driver.findElementByLinkText("Chief Executive Officer").click();
			
			//Switch back to parent window
			driver.switchTo().window(titlewin.get(0));
			
			//Switch to frame
		    driver.switchTo().frame("gsft_main");

		  //Find email and pass value
			driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("lalithavijai@gmail.com");
			
			//Find Bussinessphone and pass value
			driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("9790762277");
			
			
			//Find mobile number and pass value
			driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("9176288355");
			
			//Click on submit
			driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
			
			//Find Search dropdown and select bussiness phone
//			WebElement serele = driver.findElement(By.linkText("Search"));
//			Select dd1=new Select(serele);
//			dd1.selectByValue("last_name");
			//Enter the phone number and click enter
			driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("sai",Keys.ENTER);
		   
		   WebElement newEntry = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]"));
		   String lastName = newEntry.getText();
		   System.out.println("Last name : " +lastName);
		   if(newEntry.isDisplayed())
		   System.out.println("Verified");
		   else
		   {
			   System.out.println("Not verified");
		   }
		
	}
}