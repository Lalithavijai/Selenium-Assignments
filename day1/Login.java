package week2.day1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Chrome Driver needs to be downloaded and set to the path
		WebDriverManager.chromedriver().setup();
		
		// Launch the chrome browser
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

		//Verify that you are logged in
		String text = driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		
		//Click link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click create lead link
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Find the company name name and type the value
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizant");
		
		//Find the First name name and type the value
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Lalitha");
		
		//Find the First name name and type the value
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Vijai");
		
		// From the drop down choose the source partner
		WebElement eleDropdown1=driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd1=new Select(eleDropdown1);
		//dd1.selectByValue("LEAD_CONFERENCE");
		dd1.selectByVisibleText("Partner");
		
		// From the drop down and choose the value for Marketing Campaign
		WebElement eleDropdown2=driver.findElement(By.name("marketingCampaignId"));
		Select dd2=new Select(eleDropdown2);
		dd2.selectByVisibleText("eCommerce Site Internal Campaign");
		
		//Find the First name local and type the value
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Testlocal");
		
		//Find the First last local and type the value
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("IBACCO1");
		
		//Find the Salutation and type the value
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("SalutationTEST");
		
		//Find the DOB and type the value
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("12/04/1989");
		//Find the Title and type the value
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("TestTitle1");
		//Find the Department and type the value
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("TestDepartment");
		
		//Find the Revenue and type the value
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("2 crores");
		
		// Find the Preferred Currency drop down  and choose the value from drop down
		WebElement eleDropdown3=driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select dd3=new Select(eleDropdown3);
		dd3.selectByIndex(4);
		
		// Find the Industry drop down and choose the value from drop down
		WebElement eleDropdown4=driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select dd4=new Select(eleDropdown4);
		dd4.selectByVisibleText("Computer Software");
				
		//Find the Number Of Employees	 and type the value
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("1000");
		
		// Find the Ownership drop down  and choose the value from drop down
		WebElement eleDropdown5=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select dd5=new Select(eleDropdown5);
		dd5.selectByValue("OWN_PROPRIETOR");
		
		//Find the Number Of Code and type the value
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("AESP5643");
		
		//Find the Ticker Symbol and type the value
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("SSVA12");
				
		//Find the Description and type the value
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Have a wonderful year ahead");
		
		//Find the Impt Note and type the value
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Happy to learn selenium.This is my first selenium program ");
		
		//Find the Country code and type the value
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		
		//Find the Country code and type the value
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
				
		//Find the area code and type the value
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("200");
				
				
		//Find the Extension and type the value
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("123456");
				
				
		//Find the E-Mail Address and type the value
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("lalithavijai@gmail.com");
				
		//Find the Phone and type the value
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9176288355");
		
		//Find the Person  and type the value
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Nancy");
			
		
		//Find the Person  and type the value
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://www.google.com/");
		
		
		
		
		//Find the To name and type the value
				driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Virshanth");
						
				//Find the Attention name and type the value
				driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("John Balaji");
				
				//Find the Add1  and type the value
				driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("No 5 Joshwa Garden");
				
				//Find the Add2  and type the value
				driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("ADDRESS 2 FOR CONTACT");
				
				//Find the City  and type the value
				driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
				
				
				// Find country drop down  and choose the value from drop down
				WebElement eleDropdown7=driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
				Select dd7=new Select(eleDropdown7);
				dd7.selectByVisibleText("India");
												
				
				// Find state drop down  and choose the value from drop down
				WebElement eleDropdown6=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
				Select dd6=new Select(eleDropdown6);
				dd6.selectByVisibleText("TAMILNADU");
				
				//Find the Zipcode  and type the value
				driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600091");
				
								
				//Find the Zipcode extn  and type the value
				driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("123");
				
				//Find the Create lead button and click
				driver.findElementByClassName("smallSubmit").click();
				
				// Find the Duplicate lead button and click
			    driver.findElementByClassName("subMenuButton").click();
				
			    //Find the Company NAME and type the value
			    driver.findElement(By.id("createLeadForm_companyName")).clear();
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Google");
		
		//Find the Create lead button and click
		driver.findElementByClassName("smallSubmit").click();
		
		String text2 = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		
		if(text2.contains("Google"))
		{
		System.out.println(text2 +"is the Updated company name ");
		System.out.println("Company name verified ");
		}
		else
		{
			System.out.println("Company name is wrong ");
		}
		
	}

}
