package week4.day2.incident.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignIncident {

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

		// Click on open
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		
		List<WebElement> frams = driver.findElements(By.tagName("iframe"));
		System.out.println(frams.size());

		// Switch to iframe
		driver.switchTo().frame("gsft_main");
		
		// Wait for the element to visible
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement eleIncident = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
				WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(eleIncident));
				searchElement.sendKeys("INC0000016" ,Keys.ENTER );
				
				System.out.println(driver.findElements(By.tagName("iframe")).size());
				
				
				//Click on the searched incident number
				driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]")).click();
	
				driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span")).click();
				
				// Get window handles
				Set<String> windowHandles = driver.getWindowHandles();
				// Get the window handles in a list
				List<String> secwindow = new ArrayList<String>(windowHandles);

				// Switch to second window
				driver.switchTo().window(secwindow.get(1));
				System.out.println("2nd Window Title: " + driver.getTitle());

				// Click on first
				driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Software" , Keys.ENTER);
				driver.findElement(By.linkText("Software")).click();
				
				// switch to first window
				driver.switchTo().window(secwindow.get(0));
				
				//Switch to frame
			    driver.switchTo().frame("gsft_main");
			    
			 // Find Work notes and enter the values
			    driver.findElement(By.id("activity-stream-work_notes-textarea")).sendKeys("Sample worknotes");
			    
			    //Click on update
			    driver.findElement(By.id("sysverb_update_bottom")).click();
			    
		
			

	}

}
