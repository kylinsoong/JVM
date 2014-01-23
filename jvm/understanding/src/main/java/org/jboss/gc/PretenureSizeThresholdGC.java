package org.jboss.gc;

/**
 * VM Args: -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * 
 * How to build?
 *    mvn clean install
 * 
 * How to run?
 *    java -cp target/jvm-understanding.jar -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+PrintGCDetails org.jboss.gc.MinorGC
 */
public class PretenureSizeThresholdGC {
	
	private static final int _1MB = 1024 * 1024 ;
	
	@SuppressWarnings("unused")
	public void testPretenureSizeThreshold() {
		byte[] allocation;
		allocation = new byte[4 * _1MB];
	}

	public static void main(String[] args) {
		new PretenureSizeThresholdGC().testPretenureSizeThreshold();
	}

}
