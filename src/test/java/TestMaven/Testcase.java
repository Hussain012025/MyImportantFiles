package TestMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 
public class Testcase {
	
	@BeforeMethod
	public void openBrowser() {
		System.out.println("Ready for test");
	}

	@DataProvider(name="paymentData")
	public Object[][] paymentData(){
		return new Object[][] {
			{"Aaliya","SBIN001234","1000"},
			{"Nisha","HDFC0056780","5000"},
			{"Sheik","ICIC0099999","8000"}
		};
		
	}
	
	@Test(priority=1)
	public void login() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.harmony.bank/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@href='#oblCollapse']")).click();
		driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("Aaliya");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("785694");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		
		
		
	}
	
	@Test(priority=2,
			dependsOnMethods = "testCases.LoginTest.login",
			dataProvider ="paymentData",timeOut=10000)
	
	public void makePayment(String beneficiary,String ifsc, String amount) {
		
		//Navigate to payment page
		
	   WebDriver driver=new ChromeDriver();
	   
	   driver.findElement(By.id("payments Menu")).click();
	   
	   //Enter beneficiary details
	   
	   driver.findElement(By.id("beneficiaryName")).sendKeys("beneficiary");
	   driver.findElement(By.id("ifsc")).sendKeys("ifsc");
	   
		//Enter the amount
	   
	   driver.findElement(By.id("amount")).sendKeys("amount");
	   
	   //submit payment
	   driver.findElement(By.id("payBtn")).click();
	   System.out.println("payment initiated for"+beneficiary);
	}
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void invalidAmountTest() {
		
		String amount="ABC";
		int payment=Integer.parseInt(amount);
		//Exception excepted
		System.out.println("payment");
	}
		//After each test
		
		@AfterMethod
		
		public void closebrowser() {
			
			System.out.println("Test completed");
		}
		
	}

