package leadspage;

import org.openqa.selenium.By;

import hooks.TestNgHooks;

public class MyLeadsPage extends TestNgHooks{

	public CreateLeadPage clickCreateLead() {
		
		click(locateElement("link", "Create Lead"));
		return new CreateLeadPage();
		
}
}