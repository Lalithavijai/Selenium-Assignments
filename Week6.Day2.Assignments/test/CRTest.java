package week6.day2.assignment.test;

import org.testng.annotations.Test;

import week6.day2.assignment.base.BasePage;
import week6.day2.assignment.snwpages.SigninPage;

public class CRTest extends BasePage {

		@Test
		public void newCRTest() throws InterruptedException {
			new SigninPage().switchToFrame().userName().pswd().clickLogin().searchChange().clickChange().getCRNumber()
			.shortdescCR().submitNewCR().searchCreatedCR();
			

	}

}
