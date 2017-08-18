package com.ezpay.web.tools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private static final String PASSWORD = "0000";
	
	public static void main(String[] args) {
		List<String> samples = generateHashedPasswordSamples(10);
		verifyHashedPasswordSamples(samples);
		System.out.println("Complete!");
	}

	private static void verifyHashedPasswordSamples(List<String> samples) {
		System.out.println("--------------------------------------------------------");
		System.out.println("Verify Hashed Passwords Samples");
		System.out.println("--------------------------------------------------------");
		for (String sample : samples) {
			verifyPasswords(PASSWORD, sample);
		}
	}

	private static void verifyPasswords(String rawPassword, String encodedPassword) {
		boolean isPasswordMatched = passwordEncoder.matches(rawPassword, encodedPassword);
		if (isPasswordMatched) {
			System.out.println("[ok] Match -> rawPassword = " + rawPassword + " , encodedPassword = "
					+ encodedPassword);
		} else {
			System.out.println("[!] Not match -> rawPassword = " + rawPassword + " , encodedPassword = "
					+ encodedPassword);
		}
	}

	private static List<String> generateHashedPasswordSamples(int c) {
		System.out.println("--------------------------------------------------------");
		System.out.println("Generate Hashed Passwords Samples - size: " + c);
		System.out.println("--------------------------------------------------------");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < c; i++) {
			String password = PASSWORD;
			String hashedPassword = passwordEncoder.encode(password);
			System.out.println(i + " - " + hashedPassword);
			list.add(hashedPassword);
		}
		return list;
	}
}
