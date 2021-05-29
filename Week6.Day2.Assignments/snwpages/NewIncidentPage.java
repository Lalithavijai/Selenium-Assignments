package week6.day2.assignment.snwpages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import week6.day2.assignment.base.BasePage;
public class NewIncidentPage extends BasePage{
	public NewIncidentPage getIncidentNumber() {
		
		
				String createdIncident = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
				System.out.println(createdIncident);
				driver.findElement(By.xpath("//input[@id='incident.number']")).sendKeys(Keys.TAB);
				return this;
		
			}
public NewIncidentPage clickCallerLookup()
{
	driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']/span")).click();
	return this;
}
	public NewIncidentPage callerWinHandle()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> secwindow = new ArrayList<String>(windowHandles);
		// Switch to second window
		driver.switchTo().window(secwindow.get(1));
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Guest",Keys.ENTER);
		driver.findElement(By.linkText("Guest")).click();
		driver.switchTo().window(secwindow.get(0));
		 driver.switchTo().frame("gsft_main");
		 return this;

}
	
	// Find Short desc and enter the values
public NewIncidentPage typeshortdesc()
{
	driver.findElement(By.xpath("//input[@id='incident.short_description']"))
	.sendKeys("Sample automation testcase to run");
	return this;
}

//Click submit
public IncidentListPage submitCreate()
{
	driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	return new IncidentListPage();
}
}
