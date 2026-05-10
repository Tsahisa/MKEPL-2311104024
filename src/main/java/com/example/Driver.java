package com.example;

import java.util.logging.Logger;
import error

public class Driver {
	private static final Logger logger = Logger.getLogger(Driver.class.getName());
	private static final String COUNT_PREFIX = "Count:";

	public static void main(String[] args) {
		Counter counter = new Counter();

		counter.increment();
		counter.increment();
		counter.increment();
		logger.info(COUNT_PREFIX + counter.getCount());

		counter.decrement();
		logger.info(COUNT_PREFIX + counter.getCount());

		counter.reset();
		logger.info(COUNT_PREFIX + counter.getCount());
	}
}