package org.jboss.oom;

/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * 
 * How to build?
 *    mvn clean install
 * 
 * How to run?
 *    java -cp target/jvm-understanding.jar -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+HeapDumpOnOutOfMemoryError org.jboss.oom.DirectMemoryOOM
 *
 */
public class DirectMemoryOOM {
	
	private static final int _1MB = 1024 * 1024 ;

	public static void main(String[] args) {
//		Field unsafeField = Unsafe
	}

}
