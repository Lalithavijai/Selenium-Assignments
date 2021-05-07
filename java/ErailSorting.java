package week3.day2.assignments.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSorting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Chrome Driver needs to be downloaded and set to the path
		WebDriverManager.chromedriver().setup();

		// Launch the chrome browser
		RemoteWebDriver driver = new ChromeDriver();

		// Load the url
		driver.get("https://erail.in/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Maximize the screen
		driver.manage().window().maximize();

		// Find the user name and type the value
		WebElement toStation = driver.findElementById("txtStationTo");

		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MAS", Keys.TAB);

		// Find the user name and type the value
		toStation.clear();
		toStation.sendKeys("SBC", Keys.TAB);

		// Find the element and click
		driver.findElement(By.id("chkSelectDateOnly")).click();

		// WebElement table = driver.findElement(By.xpath("//table[@class='DataTable
		// TrainList TrainListHeader']"));
		// List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		// System.out.println(tableRows.size());
		List<String> list = new ArrayList<>();
		List<WebElement> trainNames = driver
				.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//td[2]"));
		for (int i = 0; i < trainNames.size(); i++) {

			list.add(trainNames.get(i).getText());

		}
		
		Collections.sort(list);
		System.out.println(list);
		for (String st1 : list) {
			
			System.out.println(st1);
			
		}
		
		System.out.println(list.size());
		System.out.println(list);
		
		

	}

}
