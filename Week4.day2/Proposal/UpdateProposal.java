package week4.day2.proposal.asignment;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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

public class UpdateProposal {

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
		  
		  //Thread.sleep(5000);
		 
	
		 
		 
		driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]")).click();
		
		 //Find state and select the value from drop down
		 WebElement stateDd = driver.findElement(By.id("std_change_proposal.state"));
        Select dds1= new Select(stateDd);
        dds1.selectByValue("2");
        
      //Click on category to lookup
       driver.findElement(By.id("lookup.std_change_proposal.category")).click();
        
     //SWitching windows
     	Set<String> windowHandles2 = driver.getWindowHandles();
     	List<String> catewindow = new ArrayList<String>(windowHandles2);
     		
     	//Switch to category window
     	driver.switchTo().window(catewindow.get(1));
     	
     	driver.findElement(By.linkText("Template Management")).click();
     	
     	//Switch back to parent window and frame
     	driver.switchTo().window(catewindow.get(0));
     	driver.switchTo().frame("gsft_main");
       
		//Click on assigned to lookup
		driver.findElement(By.id("lookup.std_change_proposal.assigned_to")).click();
		//SWitching windows
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> assignwindow = new ArrayList<String>(windowHandles3);
		
		//Switch to Assign  window
		driver.switchTo().window(assignwindow.get(1));
		
		//Select the value from assign to list
		driver.findElement(By.linkText("Change Manager")).click();
		
		//Switch to Parent  window and frame
		driver.switchTo().window(assignwindow.get(0));
		driver.switchTo().frame("gsft_main");
		
		//Click on Request values
		driver.findElement(By.xpath("(//span[text()='Change Request values'])[1]")).click();
		
		//click on Assignment group lookup
        driver.findElement(By.xpath("//button[@class='icon-search btn btn-default filerTableAction']")).click();
        
      //SWitching windows
      		Set<String> windowHandles4 = driver.getWindowHandles();
      		List<String> assigngrpwindow = new ArrayList<String>(windowHandles4);
      		
      //Switch to Assign  window
      driver.switchTo().window(assigngrpwindow.get(1));
        
       //Select the value
        driver.findElement(By.linkText("Analytics Settings Managers")).click();
        
      //Switch to Parent  window and frame
      	driver.switchTo().window(assigngrpwindow.get(0));
      	driver.switchTo().frame("gsft_main");
      	
      	//Find Justification and provide the comments
      	driver.findElement(By.xpath("//textarea[@aria-label='Input value for field: Justification']")).sendKeys("This is a valid Justification");
      	//Find Impact analysis and enter the comments
      	driver.findElement(By.xpath("//textarea[@aria-label='Input value for field: Risk and impact analysis']")).sendKeys("Comments updated for Risk");
      	//click on submit
      	driver.findElement(By.id("sysverb_update_bottom")).click();
      	
      //Verify the updated proposal of state
		String stateupdated = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[6]")).getText();
		System.out.println("Updated state: " +stateupdated);
		if(stateupdated.equalsIgnoreCase("In progress"))
		{
			System.out.println("State updated successfully");
		}
		else
		{
			System.out.println("State updated wrongly");
		}
		
		String updatedassigned = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[10]")).getText();
		System.out.println("Updated Assigned to: " +updatedassigned);
		
		if(updatedassigned.equalsIgnoreCase("change manager"))
		{
			System.out.println("Assigned updated successfully");
		}
		else
		{
			System.out.println("Assignedto updated wrongly");
		}	
		
	}
}