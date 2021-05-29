package week6.day2.assignment.test;

import org.testng.annotations.Test;
import week6.day2.assignment.snwpages.SigninPage;
import week6.day2.assignment.base.BasePage;




public class SnowTest extends BasePage{

	@Test
	public void snwtest() {
	new SigninPage().switchToFrame().userName().pswd().clickLogin().searchIncident().clickCreateNew()
	.switchframe().getIncidentNumber().clickCallerLookup().callerWinHandle().typeshortdesc().submitCreate();

	}

}
