package TestMaven;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class PracticeDemo {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before suite- setup the database connection");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite-closing the database connection");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test-starting the test block");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After test- ending the test block");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class- launch browser");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After class-closing the browser");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method- login");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method- logout");
	}
	@Test
	public void testcase1() {
		System.out.println("Executing the testcase1");
	}
	@Test
	public void testcase2() {
		System.out.println("Executing the testcase2");
	}
}
