package org.jboss.gc;

/**
 * VM Args: -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * 
 * How to build?
 *    mvn clean install
 * 
 * How to run?
 *    java -cp target/jvm-understanding.jar -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails org.jboss.gc.MinorGC
 */
public class MinorGC {
	
	private static final int _1MB = 1024 * 1024 ;
	
	@SuppressWarnings("unused")
	public void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation4 = new byte[2 * _1MB];
		allocation5 = new byte[2 * _1MB];
	}

	public static void main(String[] args) {
		new MinorGC().testAllocation();
	}

}
