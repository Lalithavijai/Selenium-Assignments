package week3.day2.assignments.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapInSelnium {

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
				// Declare a map
				Map<String, String> map = new TreeMap<String, String>();
				// WebElement table = driver.findElement(By.xpath("//table[@class='DataTable
				// DataTableHeader TrainList TrainListHeader']"));
				List<WebElement> rows = driver
						.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[1]"));
				List<WebElement> cols = driver
						.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]");
				for (int i = 0; i < rows.size(); i++) {
					String totalrows = rows.get(i).getText();
					String totalcols = cols.get(i).getText();
					if (totalcols.startsWith("S")) {
						map.put(totalrows, totalcols);
					}
				}
				System.out.println(map);
			}
		}
