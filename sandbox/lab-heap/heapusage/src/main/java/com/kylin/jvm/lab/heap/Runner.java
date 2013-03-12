package com.kylin.jvm.lab.heap;

/**
 * 
 * -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9010 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
 * 
 * @author kylin
 *
 */

public class Runner {

	public static void main(String[] args) {

		if(args.length != 2) {
			help();
		}
		
		try {
			int times = Integer.parseInt(args[0]);
			int interval = Integer.parseInt(args[1]);
			new HeapUsage(times, interval).run();
		} catch (NumberFormatException e) {
			help();
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
