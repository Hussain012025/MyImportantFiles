package TestMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class timeout {

	@Test(timeOut=19000,description="Verify the time out")//test case will pass
	public void testFacebook(){
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nisha");
		System.out.println(driver.getTitle());
	
		driver.quit();
		
}

}
