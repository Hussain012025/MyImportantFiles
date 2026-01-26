package TestMaven;

import org.testng.annotations.Test;

public class description {
	
	@Test(priority=1,description="Verify the application log in with valid credentials")
	public void login() {
		System.out.println("Application logged in");
	}
	
	@Test(priority=2,description="verify the product filtered correctly or not")
	public void filter() {
		System.out.println("product filtered");
		
	}
	
	@Test(priority=3,description="verify the product is working in the application or not")
	public void search() {
		System.out.println("Searching the product");
		
	}
	
	@Test(priority=4,description="Verify the application is logged out")
	public void logout() {
		System.out.println("Application logged out");
		
	}
	


}
