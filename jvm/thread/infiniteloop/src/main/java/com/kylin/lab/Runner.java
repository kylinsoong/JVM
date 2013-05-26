package com.kylin.lab;

import com.kylin.lab.threaddump.infiniteloop.InfiniteLoopThread;

public class Runner {

	public static void main(String[] args) {
		
		Thread.currentThread().setName("lab-thread-infiniteloop-main");
		
		System.out.print("\n  Thread infiniteloop Lab start...\n");
		
		new Thread(new InfiniteLoopThread("lab-thread-infiniteloop")).start();
		
		while(true) {
			
		}
	}

}
