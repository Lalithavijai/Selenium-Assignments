package week5.day2.assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead extends BaseLead {
	@DataProvider(name="TestData")
	 public Object[][] fetchData() throws InvalidFormatException, IOException{
	String[][] data = ReadExcel.readExcelData("Merge Lead");
	return data;	
	}
	@Test(dataProvider="TestData")
	public void merge2leads(String fromName,String toName) throws InterruptedException {
		
	
		
		//Click Merge Lead
		driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
		
		// Click on Widget of From Lead
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		//Switch to second window
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstwindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindows.get(1));
		
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fromName);
		
		//Click on Find lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		//Click on first lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//Switch to first window
		driver.switchTo().window(lstwindows.get(0));
		
		// Click on Widget of To Lead
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Thread.sleep(1000);
		
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> secWindow = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(secWindow.get(1));
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(toName);
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
