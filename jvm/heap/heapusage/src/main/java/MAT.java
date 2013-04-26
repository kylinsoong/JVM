import com.kylin.jvm.lab.heap.mat.BootStrap;


/**
 * 
 * java -Dcom.sun.management.jmxremote -Xms512m -Xmx512m -XX:MaxPermSize=128m -XX:+HeapDumpOnOutOfMemoryError -verbose:gc -Xloggc:gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -jar ./target/heapusage.jar 1000 1000
 * 
 * @author kylin
 *
 */
public class MAT {

	public static void main(String[] args) {
		new BootStrap().boot();
	}

}
