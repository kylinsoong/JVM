import com.kylin.jvm.lab.heap.mat.BootStrap;


/**
 * 
 * java -Dcom.sun.management.jmxremote -Xms512m -Xmx512m -XX:MaxPermSize=128m -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -Xloggc:gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -cp ./target/heapusage.jar MAT
 * 
 * @author kylin
 *
 */
public class MAT {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("  JVM Heap Analysis App start 20 threads in 200 seconds, each thread hold byte[]");
		System.out.println("  Run app like");
		System.out.println("  			  java -Dcom.sun.management.jmxremote -Xms512m -Xmx512m -XX:+HeapDumpOnOutOfMemoryError -cp ./target/heapusage.jar MAT");
		System.out.println("  jconsole can be used to track heap incerease");
		
		Thread.currentThread().sleep(1000 * 30);
		
		new BootStrap().boot();
		
		System.out.println("\n  JVM Heap Analysis App Start...");
	}

}
