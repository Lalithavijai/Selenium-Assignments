package leadspage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hooks.TestNgHooks;

public class ViewLeadPage extends TestNgHooks {

	public ViewLeadPage getTitle() {
		verifyPartialTitle("View Lead");
		return this;
	}
	
}
