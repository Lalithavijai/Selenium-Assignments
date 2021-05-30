package leadspage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;



public class LoginPage extends TestNgHooks{

	
	public LoginPage typeUserName(String userid) {
		type(locateElement("id","username"),userid);
		return this;

	}
	public LoginPage typePassword(String pswd) {
		type(locateElement("id", "password"), pswd);
		return this;
	}
	
	public HomePage typePasswordAndEnter() {
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("crmsfa",Keys.ENTER);
		return new HomePage();
	}

	
	public HomePage clickLogin() {
		click(locateElement("class", "decorativeSubmit"));
		return new HomePage();
	}
	
	public LoginPage clickLoginFailure() {
		click(locateElement("class", "decorativeSubmit"));
		return this; 
	}

}
