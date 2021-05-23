package stepdefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class MyHomePage extends BaseSetUp {

		@And("Click Leads Tab")
		public void clickLeadsTab() {
			driver.findElement(By.linkText("Leads")).click();
		}

	}