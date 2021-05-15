package week4.day2.changemgmt.assignment;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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

public class UpdateChangeRequest {

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
		filterbox.sendKeys("Change", Keys.ENTER);
	
			
		//Click on open
		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		
		//Switch to frame
		driver.switchTo().frame("gsft_main");
		
	 	 // Wait for the element to visible
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement searchBox = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
	    WebElement until = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		
	    WebElement findElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
	    Select searchdd=new Select(findElement);
	    searchdd.selectByValue("number");
		
		//Find Search box and enter the created number
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("CHG0000034" , Keys.ENTER);
		
		//Get the number of the searched Change Request
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]")).click();

		//Find the schedule tab and click
		
		driver.findElement(By.xpath("//span[text()='Schedule']")).click();
		
		//Find Planned Start date and clear the existing date and then enter the new date
		
		WebElement plannedStartDate = driver.findElement(By.xpath("//input[@id='change_request.start_date']"));
		plannedStartDate.clear();
		plannedStartDate.sendKeys("2021-05-14 23:15:02");

		
		WebElement plannedEndDate = driver.findElement(By.xpath("//input[@id='change_request.end_date']"));
		plannedEndDate.clear();
		plannedEndDate.sendKeys("2021-05-16 23:15:02");
		
		
		driver.findElement(By.xpath("//label[@id='label.ni.change_request.cab_required']")).click();
		driver.findElement(By.xpath("//input[@id='change_request.cab_date']")).clear();
		driver.findElement(By.xpath("//input[@id='change_request.cab_date']")).sendKeys("2021-05-17");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		 
			
			//Verify the updated dates
			WebElement ColNmeElement = driver.findElement(By.xpath("(//th[@name='start_date']/span/a)[1]"));
			String colName = ColNmeElement.getText();
			System.out.println(colName);
		
			WebElement colValueElement = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[7]"));
			String plannedDate = colValueElement.getText();
			System.out.println(plannedDate);
			
				
			Map<String,String> map=new TreeMap<String,String>();
			map.put(colName,plannedDate);
			System.out.println(map);
	}
}