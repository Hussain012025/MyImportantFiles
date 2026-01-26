package TestMaven;

import org.testng.annotations.Test;

public class enabled {
	@Test(enabled=false)
	public void additems() {
		System.out.println("Add items to the cart");
		
	}
	
	@Test(enabled=true)
	public void checkout() {
		System.out.println("Checking out the products");
		
	}
	@Test(invocationCount=5)
	public void payment() {
		System.out.println("Amount has been paid ");
	}

}
