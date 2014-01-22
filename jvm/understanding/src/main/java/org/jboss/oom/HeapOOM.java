package org.jboss.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * How to build?
 *    mvn clean install
 * 
 * How to run?
 *    java -cp target/jvm-understanding.jar -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError org.jboss.oom.HeapOOM
 */
public class HeapOOM {
	
	static class OOMObject {
	}

	public static void main(String[] args) {
		
		showVmArgs(args, "VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError");
		
		List<OOMObject> list = new ArrayList<OOMObject>();
		for(;;){
			list.add(new OOMObject());
		}
	}

	private static void showVmArgs(String[] args, String string) {
		if(args.length > 0 && args[0].equals("-h")) {
			System.out.println(string);
			System.exit(0);
		}
	}

}
