package TestMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Hardassert {
	
	@Test
	public void Assert() {
        WebDriver driver=new ChromeDriver();
	
	     driver.get("https://www.google.com/");
	     driver.manage().window().maximize();
	
	      String actualTitle=driver.getTitle();
	      String expectedTitle="Google";

		   Assert.assertEquals(actualTitle,expectedTitle);
		    System.out.println("Title has been verfied successfully");
		    driver.quit();
	}

}
