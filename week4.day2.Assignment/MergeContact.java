package week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		// Load the url
		driver.get("http://leaftaps.com/opentaps"); 
		
		//Maximize the screen
		driver.manage().window().maximize();
		
	
		//Find the user name and type the value
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//Find the password and type the value
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Find the login button and click
		driver.findElementByClassName("decorativeSubmit").click();

		//Click link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click Merge Contacts
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		// Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		//Switch to second window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstwindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindows.get(1));
		
		Thread.sleep(1000);
		System.out.println("Second window url:" +driver.getCurrentUrl());
		
		//Click on first contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//Switch to first window
		driver.switchTo().window(lstwindows.get(0));
		
		// Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Thread.sleep(1000);
		
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> secWindow = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(secWindow.get(1));
		
		//Click on second contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		
		//Switch to first window
		driver.switchTo().window(secWindow.get(0));
		
		//Click on merge contact
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Switch to alert window
		Alert alert = driver.switchTo().alert();
		
		//accept the alert
		alert.accept();
	
		System.out.println("Page title is " +driver.getTitle());
		
	}

}
