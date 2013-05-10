package com.kylin.jvm.lab.heap.test;

import java.util.ArrayList;
import java.util.List;

import com.kylin.jvm.lab.heap.util.Util;

/**
 * java -Dcom.sun.management.jmxremote -Xms256m -Xmx256m
 * -XX:+HeapDumpOnOutOfMemoryError -cp ./target/heapusage.jar
 * com.kylin.jvm.lab.heap.test.OutOfMemory
 * 
 * @author kylin
 * 
 */
public class OutOfMemory {

	public static void main(String[] args) throws InterruptedException {

		Thread.currentThread().setName("heap-lab-outofmemory-main");

		Thread.currentThread().sleep(10 * 1000);

		MyList list = new MyList();
		while (1 < 2) {
			System.out.println(list.size());
			list.add(Util.getMBbyte(1));
		}
	}

}
