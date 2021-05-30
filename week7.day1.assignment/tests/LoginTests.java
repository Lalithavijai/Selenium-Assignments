package tests;

import org.testng.annotations.Test;

import hooks.TestNgHooks;
import pages.LoginPage;

public class LoginTests extends TestNgHooks {
	
	@Test
	public void login() {
		new LoginPage().typeUserName("DemoSalesManager").typePasswordAndEnter("crmsfa").verifyWcMessage().clickLogout();

	}

}
