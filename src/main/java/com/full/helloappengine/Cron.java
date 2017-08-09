package com.full.helloappengine;

import java.util.Timer;
import java.util.TimerTask;



public class Cron extends TimerTask {

	public Cron() {

		System.out.println("Cron created");
	}

	public void start() {

		Timer t = new Timer();
		// This task is scheduled to run every 10 seconds

		t.scheduleAtFixedRate(this, 0, 1000);

	}

	int i = 0;

	@Override
	public void run() {

		i++;
		System.out.println("write out " + i);

	}

}
