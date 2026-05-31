package com.example;

import java.security.SecureRandom;
import java.util.logging.Logger;

public class Counter {

	private static final Logger logger = Logger.getLogger(Counter.class.getName());
	private static final SecureRandom SECURE_RANDOM = new SecureRandom();
	private static final int SESSION_ID_BOUND = 1000;

	private int count;

	public void reset() {
		count = 0;
	}

	public void increment() {
		count++;
	}

	public void decrement() {
		count--;
	}

	public int getCount() {
		return count;
	}

	public boolean checkLimitAndPrint(int limit) {
		if (limit > 0 && count > limit) {
			logger.warning("Warning: Count has exceeded the safe limit specified by the system configuration!");
			return true;
		}
		return false;
	}

	public int generateSessionId() {
		return SECURE_RANDOM.nextInt(SESSION_ID_BOUND);
	}
}
