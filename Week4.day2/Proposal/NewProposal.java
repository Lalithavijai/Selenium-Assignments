package week4.day2.proposal.asignment;


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

public class NewProposal {

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

		// Find filter search box and enter Incident and click enter
		WebElement filterbox = driver.findElement(By.xpath("//input[@id='filter']"));
		filterbox.sendKeys("proposal", Keys.ENTER);
		
		// Click on Open proposals
		driver.findElement(By.xpath("//div[text()='Open Proposals']")).click();
		
		// Switch to iframe
		driver.switchTo().frame("gsft_main");

		
		
		//Click on new
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();

		//Get the Proposal number and store it in a variable
		String propnum = driver.findElement(By.xpath("//input[@id='std_change_proposal.number']")).getAttribute("value");
		System.out.println("Prefilled number on creation : " +propnum);
		
		//Click on the Template desc lookup
		driver.findElement(By.id("lookup.std_change_proposal.short_description")).click();
		
		//Get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		
		// Get the window handles in a list
		List<String> secwindow = new ArrayList<String>(windowHandles);
		
		// Switch to second window
			driver.switchTo().window(secwindow.get(1));
			System.out.println("2nd Window Title: " + driver.getTitle());
		
			//click on the value from the list
			driver.findElementByLinkText("Issue with a web page").click();
			
			// Switch back to first window
			driver.switchTo().window(secwindow.get(0));
			
			//Switch to frame
		    driver.switchTo().frame("gsft_main");

			
			//Click on submit
			driver.findElement(By.id("sysverb_insert_bottom")).click();
		   
		    driver.switchTo().defaultContent();
		
		  //Find My proposal and click
		    System.out.println(driver.findElements(By.tagName("iframe")).size());
		   
		  driver.findElement(By.linkText("My Proposals")).click();
		  
		  //Switch to frame
		  driver.switchTo().frame("gsft_main");
		  
		//Find search and enter the value and click
		 driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(propnum,Keys.ENTER);
		  
		  Thread.sleep(5000);
		  
		
		//Get the number of the searched proposal
		
		WebElement searchedElement = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]"));
		System.out.println("Searched element " +searchedElement.getText());
		
				
		if(searchedElement.isDisplayed())
				{
			System.out.println("Verified");
				}
		else
		{
			System.out.println("Not Verified");
		}
		
	}
}