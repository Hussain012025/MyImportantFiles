package TestMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class edge {
	
WebDriver driver;
	
	@Parameters({"browser","url"})
	@Test
	public void launchapplication(String browser,String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}
		
		driver.get(url);
		System.out.println(driver.getTitle());
		driver.close();
	}



}
