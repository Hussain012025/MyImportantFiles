package TestMaven;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FilpkartDemo {
	 public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	ChromeOptions c= new ChromeOptions();
	c.addArguments("-incognito");
	
	WebDriver driver = new ChromeDriver(c);
	 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.manage().window().maximize();
	
	driver.get("https://www.flipkart.com/");
	WebElement s =driver.findElement(By.name("q"));
	s.sendKeys("iphone");
	
	WebElement find=driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone 15 (Blue, 128 GB']"));
	find.click();
	
	Set<String> w =driver.getWindowHandles();
	int size = w.size();
	System.out.println(size);
	for(String str :w) {
		String title= driver.switchTo().window(str).getTitle();
		System.out.println(title);	
	}
	
	String expectedTitle="Apple iPhone 15 (Blue, 128 GB)";
	for(String ch :w) {
		if (driver.switchTo().window(ch).getTitle().equalsIgnoreCase(expectedTitle)) {
			break;
		}
	}
	WebElement find2=driver.findElement(By.xpath("//button[text()='Add to cart']"));
	find2.click();
	driver.findElement(By.xpath("//span[text()='Add Item']"));
}
}