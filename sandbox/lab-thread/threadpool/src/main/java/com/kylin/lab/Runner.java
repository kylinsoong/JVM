package com.kylin.lab;

import com.kylin.lab.threaddump.threadpool.ThreadPoolTest;


public class Runner {

	public static void main(String[] args) {
		
		System.out.print("\n  Threaddump threadpool test start...\n\n");
		
		new ThreadPoolTest().startThread();
	}

}
