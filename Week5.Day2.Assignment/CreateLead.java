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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseLead{

	@DataProvider(name="TestData")
	 public Object[][] fetchData() throws InvalidFormatException, IOException{
	String[][] data = ReadExcel.readExcelData("Create Lead");
	return data;	
	}
	@Test(dataProvider="TestData")
	public void creatLead(String companyName,String Firstname, String Lastname) {
		
		//Click on create lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		
		//Find the company name and type the value
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		
		//Find the First name and type the value
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(Firstname);
		
		//Find the First name and type the value
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lastname);
			
		
		//Find create contact and click
		driver.findElement(By.name("submitButton")).click();
		
			
	}
	
	 
	
// @DataProvider(name="TestData")
	 
// public Object[][] fetchData(){
//	 String[][] data=new String[3][3];
//	 
//	 data[0][0]="Lalitha";
//	 data[0][1]="Vijai";
//	 data[0][2]="Computer software Department";
//	 
//	 data[1][0]="Sai";
//	 data[1][1]="Ram";
//	 data[1][2]="Computer hardware Department";
//	 
//	 data[2][0]="Anu";
//	 data[2][1]="Ravi";
//	 data[2][2]="Network";
//	 
//	 return data;
//	 
	 
	 }		 
	 

