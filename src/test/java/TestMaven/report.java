package TestMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class report {
	
	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	public void startReport() {
		//location created for the report
		
		ExtentSparkReporter spark=new ExtentSparkReporter("test-output/Nisha/ExtentReports/ExtentReport.html");
		
		//creating object for extent reports
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	@Test
	public void verifyGoogleTitle() {
		//create test entry in the extent report
		
		test=extent.createTest("verify Google Title");
		
		driver=new ChromeDriver();
		test.info("chrome browser launched");
		
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		test.info("navigated to Google website");
		
		
		String actualTitle=driver.getTitle();
		test.info("fetched website title");
		
		
		Assert.assertEquals(actualTitle,"Google");
		test.pass("Title matched successfully");
		
		driver.close();
		test.info("Browser closed");
	}
	
	@AfterTest
	public void endReport() {
		//to generate the report
		
		extent.flush();
		
	}


	
	

}
