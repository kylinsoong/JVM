package com.kylin.jvm.highcpu;

public class Runner {

	public static void main(String[] args) {
		
		new Thread(new HeavyThread("lab-cpu-heavyThread")).start();

		for(int i = 0 ; i < 5 ; i ++) {
			new Thread(new LightThread("lab-cpu-lightThread-" + i)).start();
		}
	}

	

}
