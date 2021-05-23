package stepdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class MyLeadsPage extends BaseSetUp  {

	@When("Click Find Leads Menu")
	public void clickFindLeadMenu() {
		driver.findElement(By.linkText("Find Leads")).click();

	}


}
