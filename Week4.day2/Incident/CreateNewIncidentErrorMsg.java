package week4.day2.incident.assignment;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewIncidentErrorMsg {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
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

		// Find filter search box and enter Incident and click enter
		WebElement filterbox = driver.findElement(By.xpath("//input[@id='filter']"));
		filterbox.sendKeys("incident", Keys.ENTER);
		
		// Click on Create new
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();

		// Switch to iframe
		 driver.switchTo().frame("gsft_main");
				
		// Tab from the Incident number
		driver.findElement(By.xpath("//input[@id='incident.number']")).sendKeys(Keys.TAB);
		
		
		//click on submit
         driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();

        
         String actualMessage = driver.findElement(By.xpath("//span[@class='outputmsg_text']")).getText();
         System.out.println("Error mesasge displayed :" +actualMessage);
         String expectedMessage="The following mandatory fields are not filled in: Short description, Caller";
         if(expectedMessage.equals(actualMessage))
         {
        	 System.out.println("Error message is verified");
         }
         else
         {
        	 System.out.println("Error message displayed incorrectly");
         }
	}
}
