package com.kylin.jvm.highcpu;

import java.util.Random;

public class LightThread implements Runnable {

	private String name;

	public LightThread(String name) {
		super();
		this.name = name;
	}

	public void run() {

		Thread.currentThread().setName(name);

		Long l = 0l;
		while (true) {
			l++;
			try {
				Thread.sleep(new Random().nextInt(10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (l == Long.MAX_VALUE) {
				l = 0l;
			}
		}

	}

}
