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

public class DeleteIncident {

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

		// Click on open
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		
		List<WebElement> frams = driver.findElements(By.tagName("iframe"));
		System.out.println(frams.size());

		// Switch to iframe
		driver.switchTo().frame("gsft_main");
		
		// Wait for the element to visible
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				//WebElement eleIncident = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
				//WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(eleIncident));
				driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("INC0010028" ,Keys.ENTER );
				
				System.out.println(driver.findElements(By.tagName("iframe")).size());
				
				
				//Click on the searched incident number
				driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]")).click();
				
				//Click on delete button
				driver.findElement(By.id("sysverb_delete")).click();
				driver.findElement(By.id("ok_button")).click();
				String text = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td")).getText();
				System.out.println(text);
				
				
	
		
	}
				
}
