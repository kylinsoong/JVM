package org.jboss.gc;

/**
 * VM Args: -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:-PrintTenuringDistribution
 * 
 * How to build?
 *    mvn clean install
 * 
 * How to run?
 *    java -cp target/jvm-understanding.jar -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:-PrintTenuringDistribution org.jboss.gc.TenuringThresholdGC
 */
public class TenuringThresholdGC {
	
	private static final int _1MB = 1024 * 1024 ;
	
	public void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		allocation3 = null;
		allocation3 = new byte[2 * _1MB];
		allocation3 = null;
		allocation3 = new byte[2 * _1MB];
	}

	public static void main(String[] args) {
		new TenuringThresholdGC().testTenuringThreshold();
	}

}
