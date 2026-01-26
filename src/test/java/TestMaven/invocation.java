package TestMaven;

import org.testng.annotations.Test;

public class invocation {
	
	@Test(enabled=true)
	public void additems() {
		System.out.println("Add items to the cart");
		
	}
	
	@Test(enabled=true,invocationCount=3)
	public void checkout() {
		System.out.println("Checking out the products");
		
	}
	@Test(invocationCount=2)
	public void payment() {
		System.out.println("Amount has been paid ");
	}

}
