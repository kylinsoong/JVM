package org.jboss.oom;

/**
 * VM Args: -Xss2M
 * 
 * How to build?
 *    mvn clean install
 * 
 * How to run?
 *    java -cp target/jvm-understanding.jar -Xss128k org.jboss.oom.JavaVMStackOOM
 *
 */
public class JavaVMStackOOM {

	
	private void dontStop() {
		while (true) {
		}
	}
	
	public void stackLeakByThread() {
		while(true) {
			Thread thread = new Thread(new Runnable(){

				public void run() {
					dontStop();
				}});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
