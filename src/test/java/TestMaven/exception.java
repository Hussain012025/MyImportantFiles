package TestMaven;

import org.testng.annotations.Test;

public class exception {

	@Test(
			description="verify the exception in the test case-for negative testing ",
			expectedExceptions = ArithmeticException.class
			)
	public void exceptionTest() {
		int a=10/0;//expected exception
	}
	

}
