package com.kylin.lab;

import com.kylin.lab.threaddump.infiniteloop.InfiniteLoopThread;

public class Runner {

	public static void main(String[] args) {
		
		System.out.print("\n  Threaddump infiniteloop test start...\n");
		
		Thread t1 = new Thread(new InfiniteLoopThread("lab-threaddump-thread-infiniteloop"));
		t1.start();
		
		Thread.currentThread().setName("lab-threaddump-thread-infiniteloop-main");
		
		while(true) {
			
		}
	}

}
