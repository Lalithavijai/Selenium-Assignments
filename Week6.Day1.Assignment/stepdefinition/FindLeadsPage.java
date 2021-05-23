package stepdefinition;


import org.openqa.selenium.By;

import io.cucumber.java.en.And;

public class FindLeadsPage extends BaseSetUp {
	String capturedLeadId;
	@And("Click on Phone Tab")
	public void clickPhoneTab() {
		driver.findElement(By.xpath("(//a[@href='#']//em)[2]")).click();

	}

	@And("Enter Phone Numer as (.*)$")
	public void getPhoneNumber(String phNum) {
		driver.findElement(By.name("phoneNumber")).sendKeys(phNum);
	}

	@And("Capture lead ID of First Matching lead")
	public void captureFirstResultantId() {
		capturedLeadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a"))
				.getText();
		System.out.println("Lead Id: " + capturedLeadId);
	}

	@And("Click Delete Button")
	public void performDeleteAction() {
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
	}

	@And("Enter the Captured LeadId")

	public void enterCapturedId() {
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(capturedLeadId);
	}

	@And("Verify the Status")

	public void verifyDeleteStatus() {

		boolean status = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();

		if (status) {
			System.out.println("This message confirms the successful deletion of the mentioned Lead Id");
		} else {
			System.err.println("Deletion step failed");
		}
	}
}