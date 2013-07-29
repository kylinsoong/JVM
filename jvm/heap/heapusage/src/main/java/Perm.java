
/**
 * java -Dcom.sun.management.jmxremote -Xms400m -Xmx400m -XX:PermSize=128m -XX:MaxPermSize=128m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author kylin
 *
 */
public class Perm {
	
	static int index = 1;

	public static void main(String[] args) throws InterruptedException {
		System.out.println(index++);
		Thread.currentThread().sleep(1000);
		System.out.println(args[0]);
		main(new String[] { (args[0] + args[0]).intern() });
	}

}
