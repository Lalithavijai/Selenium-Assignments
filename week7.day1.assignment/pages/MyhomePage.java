package leadspage;

import org.openqa.selenium.By;

import hooks.TestNgHooks;

public class MyhomePage extends TestNgHooks {

	public MyLeadsPage clickLeadsTab() {
		
		click(locateElement("link","Leads"));
		return new MyLeadsPage();
	}

}
