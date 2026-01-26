package TestMaven;

import org.testng.annotations.Test;

public class alwaysrun {
	
	@Test(priority=1)
	public void login() {
		System.out.println("App logged in ");
	}
	
	@Test(dependsOnMethods="logout",alwaysRun=true)
	public void payment() {
		System.out.println("payment need to proceed for the product");
		
	}
	


}
