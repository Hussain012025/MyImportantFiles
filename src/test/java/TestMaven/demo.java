package TestMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class demo {
	
	@Test (priority=1)
	public void login() {

     WebDriver driver=new ChromeDriver();
     
     driver.get("https://www.google.com/");
     driver.manage().window().maximize();
     driver.navigate().to("https://www.saucedemo.com/");
      
     //Find user Name and set username
     WebElement txtbx=driver.findElement(By.name("user-name"));
     txtbx.sendKeys("error_user");
    
     //Password is set
     driver.findElement(By.name("password")).sendKeys("secret_sauce");
     
     //signin
      driver.findElement(By.xpath("//input[@type='submit']")).click();
            
      //Addcart
      driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
	  driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
  
      //checkoutbutton
      driver.findElement(By.id("checkout")).click();
      driver.findElement(By.id("first-name")).sendKeys("Nisha");
      driver.findElement(By.id("last-name")).sendKeys("Sheik");
      driver.findElement(By.id("postal-code")).sendKeys("62500");
      System.out.println("Checkout the all Elements");
      
      //continue
      driver.findElement(By.id("continue")).click();
      System.out.println("All methods are worked");
      driver.close();
      
	} 
	
	@Test(priority=2)
	public void NegativeUserName() {
		 WebDriver driver=new ChromeDriver();
		 driver.navigate().to("https://www.saucedemo.com/");
		 WebElement txtbx=driver.findElement(By.name("user-name"));
	     txtbx.sendKeys("error_user");
	     
	     driver.findElement(By.name("password")).sendKeys("nisha13");
	     driver.findElement(By.xpath("//input[@type='submit']")).click();
	     driver.findElement(By.xpath("//div[@class='error-message-container error']")).sendKeys("nisha13");
	     System.out.println("Invalid Passwords");
	     
	}
  }



