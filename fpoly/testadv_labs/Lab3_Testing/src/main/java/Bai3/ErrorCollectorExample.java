package Bai3;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorExample {
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void example() {
		collector.addError(new Throwable("There is an error in first line!"));
		collector.addError(new Throwable("There is an error in second line!"));
		System.out.println("Hello");
		try {
			assertTrue("A " == "B");
		} catch (Throwable t) {
			collector.addError(t);
		}
		System.out.println("World!");
	}
}
