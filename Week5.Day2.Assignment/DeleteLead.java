package week5.day2.assignment;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseLead{
	@DataProvider(name="TestData")
	 public Object[][] fetchData() throws InvalidFormatException, IOException{
	String[][] data = ReadExcel.readExcelData("Delete Lead");
	return data;	
	}
	
	@Test(dataProvider="TestData")
	public void delLead(String phonenumber) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//Click phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//Enter phone
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonenumber);
		
		//Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//Capture first matching
		String text2 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
		//String text2 = driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).getText();
		System.out.println(text2);
	
		//click the first matching
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//Click delete
		driver.findElement(By.linkText("Delete")).click();
		
		//Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		
		//Enter lead id and enter the  value
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[1]")).sendKeys(text2);
		
		//Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		
		
		
	}

}
