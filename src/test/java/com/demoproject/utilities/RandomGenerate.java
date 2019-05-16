package com.demoproject.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomGenerate {

	public static void main(String[] args) {
		System.out.println(RandomStringUtils.randomAlphabetic(10));
		String a = RandomStringUtils.randomAlphabetic(10);
		System.out.println(a.toLowerCase());
		System.out.println(a.toUpperCase());
		System.out.println(RandomStringUtils.randomNumeric(5));
		System.out.println(RandomStringUtils.randomAlphanumeric(5));

	}

}
