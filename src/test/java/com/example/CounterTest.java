package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class CounterTest {

	@Test
	public void testReset() {
		Counter testCounter = new Counter();

		for (int i = 0; i < 10; i++) {
			testCounter.increment();
		}

		testCounter.reset();

		assertEquals(0, testCounter.getCount(), 0);
	}

	@Test
	public void testIncrement() {
		Counter testCounter = new Counter();

		for (int i = 1; i < 10; i++) {
			testCounter.increment();
			assertEquals(i, testCounter.getCount(), i);
		}
	}

	@Test
	public void testDecrement() {
		Counter testCounter = new Counter();

		for (int i = 1; i < 10; i++) {
			testCounter.decrement();
			assertEquals(i * -1, testCounter.getCount(), i * -1);
		}
	}

}
