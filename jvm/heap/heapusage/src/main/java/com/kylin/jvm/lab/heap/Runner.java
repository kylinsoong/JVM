package com.kylin.jvm.lab.heap;

import java.io.IOException;

/**
 * 
 * How to Run?
 * 
 * java -Dcom.sun.management.jmxremote -Xms400m -Xmx400m -XX:PermSize=64m -XX:MaxPermSize=64m -verbose:gc -Xloggc:gc-heapusage.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -jar ./target/heapusage.jar 400 2000
 * 
 * @author kylin
 *
 */

public class Runner {

	public static void main(String[] args) throws IOException {

		if(args.length != 2) {
			help();
		}
		
		try {
			int times = Integer.parseInt(args[0]);
			int interval = Integer.parseInt(args[1]);
			System.out.println("\n  Press Enter to increase heap " + times + " times(each times 1MB), time interval " + interval + " milliseconds");
			System.out.println("\n");
			System.in.read();
			new HeapUsage(times, interval).run();
		} catch (NumberFormatException e) {
			help();
		} catch (IOException e) {
			throw e ;
		}
	}

	private static void help() {
		System.out.println("HeapUsage increase heap with 1MB size continuely");
		System.out.println("You need define heap increase time and heap increase interval");
		System.out.println("Run HeapUsage with parameter: <heap increase time> <heap increase interval>");
		System.out.println("For example");
		System.out.println("	java -jar heapusage.jar 1000 1000");
		Runtime.getRuntime().exit(0);
	}

}
