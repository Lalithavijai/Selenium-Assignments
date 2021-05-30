package hooks;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ReadExcel;
import wrappers.BaseDriver;

public class TestNgHooks extends BaseDriver {

	@BeforeSuite
	public void init()
	{
		//Start reporting

	}
	@BeforeTest
	public void setUpTests()
	{
		//Later

	}
	@BeforeClass
	public void beforeClass()
	{
		//Later

	}
	
	@BeforeMethod
	public void invoke()
	{
		//Start the app
		startApp("chrome","http://leaftaps.com/opentaps");

	}
	
	@AfterMethod
	public void close()
	{
		closeActiveBrowser();
	
	}
	
	@AfterClass
	public void afterClass()
	{
		//Later
	
	}
	
	@AfterTest
	public void completeTests()
	{
		//Later
	
	}
	@AfterSuite
	public void completeSuite()
	{
		//Later
	
	}
//	@Before()
//	public void initBefore()
//	{
//		invoke();
//	}
//	@After()
//	public void afterClose()
//	{
//		close();
//	}
	
	@DataProvider(name="readExcelData")
	public Object[][] fetchData() throws InvalidFormatException, IOException {
		return ReadExcel.readExcelData("Create Lead");	
	
}
}