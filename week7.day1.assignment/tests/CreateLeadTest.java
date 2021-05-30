package tests;

import org.testng.annotations.Test;

import hooks.TestNgHooks;
import leadspage.LoginPage;


public class CreateLeadTest extends TestNgHooks {

	@Test(dataProvider="readExcelData")
	public void createLead(String compName,String firstName,String lastName,String email) {
		new LoginPage().typeUserName("DemoSalesManager").typePassword("crmsfa").clickLogin()
		.getTitle().clickCRMSFAlink().clickLeadsTab().clickCreateLead().enterCompany(compName)
		.enterFirstName(firstName).enterLastName(lastName).enterEmail(email).clickCreateLeadButton()
		.getTitle();
	}

}
