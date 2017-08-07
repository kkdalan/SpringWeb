package com.ezpay.web.util.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzDemo {

	public static void main(String[] args) throws IOException, SchedulerException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-servlet.xml");
		System.out.println("Start running Task...");
		System.out.println("Input <exit> to stop task:");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			if (reader.readLine().equalsIgnoreCase("exit")) {
				System.out.println("Stop Task!");
				break;
			}
		}
		
		Scheduler scheduler = (Scheduler) ac.getBean("schedulerFactoryBean");
		scheduler.shutdown();

	}
}
