package leadspage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hooks.TestNgHooks;


public class HomePage extends TestNgHooks {

	public HomePage getTitle() {
		verifyPartialText(locateElement("tag", "h2"), "Welcome");
		return this;	
	}
	public LoginPage clickLogout() {
		click(locateElement("class", "decorativeSubmit"));
		return new LoginPage();
	}
public MyhomePage clickCRMSFAlink()
{
	click(locateElement("link", "CRM/SFA"));
	return new MyhomePage();
}
	}
