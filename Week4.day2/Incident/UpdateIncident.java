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

public class UpdateIncident {

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

	

		// Find filter search box and enter Incident and click enter
		WebElement filterbox = driver.findElement(By.xpath("//input[@id='filter']"));
		filterbox.sendKeys("incident", Keys.ENTER);

		// Click on Create new
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();

		// Switch to iframe
		driver.switchTo().frame("gsft_main");

		// Get the Incident number and store it in a variable
		String createdIncident = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println(createdIncident);

		// Tab from the Incident number

		driver.findElement(By.xpath("//input[@id='incident.number']")).sendKeys(Keys.TAB);

		// Find the caller and enter the value

		

		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']/span")).click();

		// Get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		// Get the window handles in a list
		List<String> secwindow = new ArrayList<String>(windowHandles);

		// Switch to second window
		driver.switchTo().window(secwindow.get(1));
		System.out.println("2nd Window Title: " + driver.getTitle());

		// Click on first
		driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]")).click();

		// switch to first window
		driver.switchTo().window(secwindow.get(0));
	    driver.switchTo().frame("gsft_main");

		System.out.println(driver.getTitle());

		// Find Short desc and enter the values

		driver.findElement(By.xpath("//input[@id='incident.short_description']"))
				.sendKeys("Sample automation testcase to run");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();

		// Wait for the element to visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement eleIncident = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(eleIncident));
		until.sendKeys(createdIncident, Keys.ENTER);
		
//		 WebElement eleDropDown3 = driver.findElement(By.id("context_list_titleincident"));
//		  Select dd3= new Select(eleDropDown3);
//		  dd3.selectByValue("number");
		    
		
		WebElement searchedElement = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]/a"));
		String searchedIncident = searchedElement.getText();
		System.out.println(searchedIncident);
		searchedElement.click();
	
		
		
		WebElement eleDropDown1 = driver.findElement(By.id("incident.urgency"));
		Select dd1=new Select(eleDropDown1);
		dd1.selectByValue("1");
		
		WebElement eleDropDown2 = driver.findElement(By.id("incident.state"));
		
		// instead of creating reference can be accessed as below with new keyword
		new Select(eleDropDown2).selectByValue("2");
		
		
		driver.findElement(By.id("sysverb_update_bottom")).click();
		String text = eleDropDown2.getText();
	
			if(text.contains("High"))
			{
				System.out.println("Verified");
			}
	
	

		

	}

}
