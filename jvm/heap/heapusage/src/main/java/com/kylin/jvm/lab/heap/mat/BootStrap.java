package com.kylin.jvm.lab.heap.mat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BootStrap {
	
	private static final int T_THREAD = 20 ;

	@SuppressWarnings("static-access")
	public void boot() throws InterruptedException {
				
		ExecutorService executor = Executors.newFixedThreadPool(T_THREAD);
		
		for(int i = 0 ; i < T_THREAD ; i ++) {
			HeapTestThread thread = new HeapTestThread(i);
			executor.execute(thread);
			Thread.currentThread().sleep(1000 * 10);
		}
	}
}
