package com.kylin.jvm.lab.heap.test;

import java.util.ArrayList;
import java.util.List;

import com.kylin.jvm.lab.heap.util.Util;


/**
 * java -Dcom.sun.management.jmxremote -Xms512m -Xmx512m -XX:MaxPermSize=128m -XX:+HeapDumpOnOutOfMemoryError -cp ./target/heapusage.jar com.kylin.jvm.lab.heap.test.Test
 * 
 * @author kylin
 *
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		Thread.currentThread().setName("heap-lab-test-main");
		
		Thread.currentThread().sleep(10 * 1000);
		
//		System.out.println("create 100 MB size buffer");
//		byte[] buf = Util.getMBbyte(100);
		
		System.out.println("create 100 MB size String");
		List<String> list = new ArrayList<String> ();
		list.add(Util.getMBString(100));
		
		Thread.currentThread().sleep(Long.MAX_VALUE);
	}

}
