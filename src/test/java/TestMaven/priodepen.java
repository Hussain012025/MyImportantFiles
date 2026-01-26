package TestMaven;

import org.testng.annotations.Test;

public class priodepen {
	@Test(priority=1)
	public void login() {
		
		System.out.println("App logged in ");
		
	}
	@Test(priority=2,dependsOnMethods="login")
	public void homepage() {

		System.out.println("Home page is displayed");
	}
	
	@Test(priority=3,dependsOnMethods="homepage")
	public void logout() {
		System.out.println("App logged out");
		
	}



}
