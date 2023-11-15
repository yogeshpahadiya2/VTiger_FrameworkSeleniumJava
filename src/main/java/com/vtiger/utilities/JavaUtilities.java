package com.vtiger.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtilities {
	/**
	 * this method will return the current system date in specified format
	 * 
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String currentdate = formatter.format(d);
		return currentdate;
	}

	/**
	 * this method will generate a random number for every run
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		int value = r.nextInt(1000);
		return value;

	}

}
