package Bai3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JunitAnnotationsExample {
	private ArrayList<String> list;

	@BeforeClass
	public static void m1() {
		System.out.println("Using @BeforeClass annotations, executed before all test cases!");
	}

	@Before
	public void m2() {
		list = new ArrayList<String>();
		System.out.println("using @Before annotations, executed before each test cases");
	}

	@AfterClass
	public static void m3() {
		System.out.println("using @AfterClass annotations, executed after all test cases");
	}

	@After
	public void m4() {
		System.out.println("using @After annotations, executed after each test cases");
	}

	@Test
	public void m5() {
		list.add("Test");
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
	}

	@Ignore
	public void m6() {
		System.out.println("using @Ignore annotations, this execution is ignored!");
	}

	@Test(timeout = 5)
	public void m7() {
		System.out.println("using @Test(timeout), it can be used to enfore timeout in JUnit4 test case!");
	}

	@Test(expected = NoSuchMethodException.class)
	public void m8() {
		System.out.println("using @Test(expected), it will check for specified exception during its execution!");
	}

}
