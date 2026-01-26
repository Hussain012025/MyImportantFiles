package TestMaven;

import org.testng.annotations.Test;

public class threadpool {

	@Test(invocationCount=4,threadPoolSize=2)
	public void searchProduct() {
		System.out.println("Searching the product in the application");
		System.out.println("Thread ID: "+Thread.currentThread().getName());
	}
	
	@Test(enabled=false)
	public void orderStatus() {
		System.out.println("Order update");
	}

}
