package Bai1;

import static org.testng.Assert.assertTrue;

import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryInstantiatedTestClass implements ITest {
	private String param;

	public FactoryInstantiatedTestClass(String param) {
		this.param = param;
	}

	public String getTestName() {
		return getClass().getSimpleName() + "-" + param;
	}

	@Factory
	public static Object[] create() {
		return new Object[] { new FactoryInstantiatedTestClass("TestNG"), new FactoryInstantiatedTestClass("Reports") };
	}

	@Test
	public void f() {
		if (param.equals("Reports")) {
			assertTrue(false);
		}
	}
}
