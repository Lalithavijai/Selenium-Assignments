package week6.day2.assignment.snwpages;

import java.util.List;
import week6.day2.assignment.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SigninPage extends BasePage{

	public SigninPage switchToFrame() {
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		driver.switchTo().frame("gsft_main");
		return this;
		
	}
public SigninPage userName()
{
	driver.findElement(By.id("user_name")).sendKeys("admin");
	return this;
}

public SigninPage pswd()
{
	driver.findElement(By.id("user_password")).sendKeys("India@123");
	return this;
}
public MenuPage clickLogin()
{
	driver.findElement(By.id("sysverb_login")).click();
	return new MenuPage();
}

}
