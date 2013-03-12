package com.kylin.jvm.lab.heap;

import java.util.HashMap;
import java.util.Map;

public class HeapUsage {

	private static final int INIT_SIZE = 1024 * 1000 ;
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	private int times;
	
	private int interval;
	
	private long defValue = System.currentTimeMillis();
			
	public HeapUsage(int times, int interval) {
		super();
		this.times = times;
		this.interval = interval;
	}
	
	public void run() {
		for(int i = 0 ; i < times ; i ++) {
			addToMap("heapusage-" + i);
			sleep(interval);
			System.out.println((System.currentTimeMillis() - defValue) + ", maxMemory: " + Runtime.getRuntime().maxMemory() + ", totalMemory: " + Runtime.getRuntime().totalMemory() + ", freeMemory: " + Runtime.getRuntime().freeMemory());
		}
		sleep(Long.MAX_VALUE);
	}


	@SuppressWarnings("static-access")
	private void sleep(long interval) {
		try {
			Thread.currentThread().sleep(interval);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	private void addToMap(String key) {
		map.put(key, new byte[INIT_SIZE]);
	}
}
