package week6.day2.assignment.snwpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import week6.day2.assignment.base.BasePage;

public class NewCRPage extends BasePage {
	String newNumber;
	public NewCRPage getCRNumber() {
		newNumber = driver.findElement(By.xpath("//input[@id='change_request.number']")).getAttribute("value");
		System.out.println("Prefilled number on creation : " +newNumber); 
		return this;

	}
	
	public NewCRPage shortdescCR() {
		driver.findElement(By.xpath("//input[@name='change_request.short_description']")).sendKeys("This is for automation testing"); 
		return this;
}
	public MenuPage submitNewCR() {
		driver.findElement(By.id("sysverb_insert_bottom")).click(); 
		driver.switchTo().defaultContent();
		return new MenuPage();
}
}