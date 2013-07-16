package com.kylin.jvm.lab.heap;

import java.io.IOException;

/**
 * 
 * How to Run?
 * 
 * java -Dcom.sun.management.jmxremote -Xms400m -Xmx400m -XX:PermSize=64m -XX:MaxPermSize=64m -verbose:gc -Xloggc:gc-heapusage.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+HeapDumpOnOutOfMemoryError -jar overhead.jar
 * 
 * @author kylin
 *
 */

public class Runner {

	public static void main(String[] args) throws IOException {

		
		try {
			System.out.println("\n  Press Enter to start GC overhead limit exceeded Lab ... ");
			System.out.println("\n");
			System.in.read();
			new HeapGCOverHead().run();
		} catch (NumberFormatException e) {
			help();
		} catch (IOException e) {
			throw e ;
		}
	}

	private static void help() {
		System.out.println("Heap GC overhead limit exceeded");
		System.out.println("	-Dcom.sun.management.jmxremote");
		System.out.println("	-Xms400m -Xmx400m -XX:PermSize=64m -XX:MaxPermSize=64m");
		System.out.println("	-verbose:gc -Xloggc:gc-heapusage.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps");
		System.out.println("	-XX:+HeapDumpOnOutOfMemoryError");
		System.out.println("Run like:");
		System.out.println("	java -jar overhead.jar");
		Runtime.getRuntime().exit(0);
	}

}
