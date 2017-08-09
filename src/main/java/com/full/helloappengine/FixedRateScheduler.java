package com.full.helloappengine;

import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class FixedRateScheduler {

	@Scheduled(fixedRate = 5000)
	public void run() throws InterruptedException {
		System.out.println("Fixed rate scheduler is running at " + new Date());
		Thread.sleep(3000);
	}

}