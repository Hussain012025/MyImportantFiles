package TestMaven;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyFirstTestcase {
	 WebDriver driver=new ChromeDriver();
@Test(priority=1)
	public void launchBrowser() {
	 driver.get("https://google.com/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     driver.navigate().to("https://www.flipkart.com/");
	}
    // Close Login Popup
    @Test(priority = 2)
    public void closeLoginPopup() {
        driver.findElement(By.xpath("span[@role['button']")).click();  
        Assert.assertTrue(true);
    }

    //  Search Product
    @Test(priority = 3, dependsOnMethods = "closeLoginPopup")
    public void searchProduct() {
        driver.findElement(By.name("q")).sendKeys("iphone");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.getTitle().contains("iphone"));
    }

    // Invocation Count
    @Test(priority = 3, invocationCount = 2)
    public void refreshPage() {
        driver.navigate().refresh();
    }

    //  TimeOut Example
    @Test(priority = 4, timeOut = 5000)
    public void verifyTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.length() > 0);
    }

    // Data Provider Example
    @Test(dataProvider = "searchData")
    public void searchMultipleProducts(String product) {
    	driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(product);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue(driver.getTitle().contains(product));
        System.out.println("Search data");
       
    }

    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
            {"laptop"},
            {"mobile"},
            {"headphone"}
         
        };
  
    }
	 
    } 
     
     
