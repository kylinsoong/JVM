package org.jboss.oom;

/**
 * VM Args: -Xss128k
 * 
 * How to build?
 *    mvn clean install
 * 
 * How to run?
 *    java -cp target/jvm-understanding.jar -Xss128k org.jboss.oom.JavaVMStackSOF
 *
 */
public class JavaVMStackSOF {
	
	public int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	

	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length: " + oom.stackLength);
			throw e;
		}
	}

}
