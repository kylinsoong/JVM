package com.kylin.jvm.highcpu;

public class Runner {

	public static void main(String[] args) {
		
		if(args.length < 1) {
			usage();
		}
		
		int threadCount = 0;
		
		try {
			threadCount = Integer.parseInt(args[0]);
			if(threadCount < 1) {
				usage();
			}
		} catch (NumberFormatException e) {
			usage();
		}
		
		for(int i = 0 ; i < threadCount ; i ++) {
			new Thread(new HighCPUUsageThread(i + 1)).start();
		}
	}

	private static void usage() {
		System.out.println("Run application with threadCount parameters");
		System.out.println("	java -jar highCPUUsage.jar 10");
		System.out.println("Application exit");
		Runtime.getRuntime().exit(0);
	}

}
