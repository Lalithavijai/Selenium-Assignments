package leadspage;

import org.openqa.selenium.By;

import hooks.TestNgHooks;


public class CreateLeadPage extends TestNgHooks {

	public CreateLeadPage enterCompany(String compName) {
		type(locateElement("id", "createLeadForm_companyName"), compName);
		return this;
	}
	public CreateLeadPage enterFirstName(String firstName) {
		type(locateElement("id", "createLeadForm_firstName"), firstName);
		return this;
}
	public CreateLeadPage enterLastName(String lastName) {
		type(locateElement("id", "createLeadForm_lastName"), lastName);
		return this;
}
	
	public CreateLeadPage enterEmail(String email) {
		type(locateElement("id", "createLeadForm_primaryEmail"), email);
		return this;
	}
	public ViewLeadPage clickCreateLeadButton()
	{
		click(locateElement("class", "smallSubmit"));
		return new ViewLeadPage();
		
	}
}
