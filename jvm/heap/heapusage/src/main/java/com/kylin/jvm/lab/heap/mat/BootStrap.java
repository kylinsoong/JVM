package com.kylin.jvm.lab.heap.mat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BootStrap {
	
	private static final int T_THREAD = 20 ;

	public void boot() {
		
		Threshold threshold = new Threshold();
		
		ExecutorService executor = Executors.newFixedThreadPool(T_THREAD);
		
		for(int i = 0 ; i < T_THREAD ; i ++) {
			HeapTestThread thread = new HeapTestThread(i,threshold);
			executor.execute(thread);
		}
	}
}
