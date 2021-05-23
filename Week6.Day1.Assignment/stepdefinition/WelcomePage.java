package stepdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class WelcomePage extends BaseSetUp {
	
	@And("Click CRM SFA Link")
	public void clickCrmSfa() {
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
}
