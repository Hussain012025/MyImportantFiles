package TestMaven;

import org.testng.annotations.Test;

public class dependson {
	
	@Test
	public void login() {
		
		System.out.println("App logged in ");
		
	}
	@Test(dependsOnMethods="login")
	public void homepage() {

		System.out.println("Home page is displayed");
	}
	
	@Test(dependsOnMethods="homepage")
	public void logout() {
		System.out.println("App logged out");
		
	}



}
