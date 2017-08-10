package com.ezpay.web.util.generator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {

	private static final String PASSWORD = "Tom";

	public static void main(String[] args) {
		List<String> passwdList = generateEncodedPasswordSamples(5);
		verifyPasswordSamples(passwdList);
	}

	private static void verifyPasswordSamples(List<String> passwdList) {
		System.out.println("----------------------------------------------");
		System.out.println("Verify Passwords");
		System.out.println("----------------------------------------------");
		for (String encodedPassword : passwdList) {
			String rawPassword = PASSWORD;
			verifyPassword(rawPassword, encodedPassword);
		}
	}

	private static void verifyPassword(String rawPassword, String encodedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isPasswordMatched = passwordEncoder.matches(rawPassword, encodedPassword);
		if (isPasswordMatched) {
			System.out.println("[ok] Passwords match! => rawPassword = " + rawPassword + ", encodedPassword = " + encodedPassword);
		}
	}

	private static List<String> generateEncodedPasswordSamples(int c) {
		List<String> passwdList = new ArrayList<String>();
		System.out.println("----------------------------------------------");
		System.out.println("Generate Passwords");
		System.out.println("----------------------------------------------");
		int i = 0;
		while (i < c) {
			String password = PASSWORD;
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			System.out.println(i + " -> " + hashedPassword);
			passwdList.add(hashedPassword);
			i++;
		}
		return passwdList;
	}
}
