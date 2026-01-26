package TestMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class data {
	
	@DataProvider(name="testFacebook")
	public Object[][] getData(){
		return new Object[][] {
			{"nisha","test123"},
			{"invalid","wrongpass"}
		};
	}
	
	@Test(description="Verify the login with different credentials",
			dataProvider="testFacebook")
	
	public void testFacebook(String username,String password){
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		System.out.println(driver.getTitle());
		
		System.out.println("login attempted with: "+username);
	
		
		
}
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		System.out.println("Application should close");
	
	  
     
	}
	   
}

