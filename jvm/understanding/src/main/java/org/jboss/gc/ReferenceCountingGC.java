package org.jboss.gc;

/**
 * VM Args: -Xms20m -Xmx20m -verbose:gc -Xloggc:gc.log -XX:+PrintGCDetails
 * 
 * How to build?
 *    mvn clean install
 * 
 * How to run?
 *    java -cp target/jvm-understanding.jar -Xms20m -Xmx20m -verbose:gc -Xloggc:gc.log -XX:+PrintGCDetails org.jboss.gc.ReferenceCountingGC
 */
public class ReferenceCountingGC {
	
	public Object instance = null;

	private static final int _1MB = 1024 * 1024 ;
	
	private byte[] bigSize = new byte[2 * _1MB];
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		
		System.gc();

		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		Thread.currentThread().sleep(2000);
		
		System.gc();
	}

}
