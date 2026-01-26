package TestMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class priority {
	WebDriver driver;
	@Test(priority =1)
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser has been opened");
		
		
	}

	@Test(priority =2)
	public void enterDetails() {
		System.out.println("Username and password detailed entered");
	}
	@Test(priority =3)
	public void loginAccount() {
		System.out.println("Account has been logged in successfully");
	}
	



}
