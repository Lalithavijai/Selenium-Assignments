package week6.day2.assignment.snwpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import week6.day2.assignment.base.BasePage;
public class MenuPage extends BasePage {

	public MenuPage searchIncident() {
		WebElement filterbox = driver.findElement(By.xpath("//input[@id='filter']"));
		filterbox.sendKeys("Incident", Keys.ENTER);
		return this;

	}
	
	public MenuPage searchChange() {
		WebElement filterbox = driver.findElement(By.xpath("//input[@id='filter']"));
		filterbox.sendKeys("Change", Keys.ENTER);
		return this;

	}
	
	public NewCRPage clickChange() {
		driver.findElement(By.xpath("(//div[text()='Create New'])[3]")).click();
		driver.switchTo().frame("gsft_main");
		WebElement normal = driver.findElement(By.xpath("(//div[@class='chg-model-model-name change-model-truncate'])[2]"));
		normal.click();
		return new NewCRPage();
	}
	
	public MenuPage clickCreateNew() {
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		return this;
	}
public NewIncidentPage switchframe()
{
	driver.switchTo().frame("gsft_main");
	return new NewIncidentPage();
}

public MenuPage searchCreatedCR() throws InterruptedException
{
	driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
	driver.switchTo().frame("gsft_main");
	 // Wait for the element to visible
	Thread.sleep(5000);
	NewCRPage crNumber=new NewCRPage();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement searchBox = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
	WebElement until = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
	until.sendKeys(crNumber.newNumber, Keys.ENTER);
	Thread.sleep(2000);
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
	
	return this;
}
}
