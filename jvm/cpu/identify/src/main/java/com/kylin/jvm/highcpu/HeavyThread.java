package com.kylin.jvm.highcpu;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class HeavyThread implements Runnable {

	private String name;

	public HeavyThread(String name) {
		super();
		this.name = name;
	}

	public void run() {

		Thread.currentThread().setName(name);

		while (true) {
			String data = "";

			// make some shit up
			for (int i = 0; i < 10000; i++) {
				data += UUID.randomUUID().toString();
			}

			MessageDigest digest;
			try {
				digest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}

			// hash that shit
			digest.update(data.getBytes());
		}

	}

}
