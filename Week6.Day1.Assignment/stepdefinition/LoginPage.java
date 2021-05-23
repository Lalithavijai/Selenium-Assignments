package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage extends BaseSetUp {

	@Given("Launch Chrome Browser")
	public void launchBrowser()  {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@When("Load url {string}")
	public void loadurl(String url) {
		driver.get(url);
	}

	@And("Type Username as {string}")
	public void userName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
		
	}
	
	@And("Type Password as {string}")
	public void password(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	@And("Click Login Button")
	public void login() {
		driver.findElementByClassName("decorativeSubmit").click();

	}

}
