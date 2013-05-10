package com.kylin.jvm.lab.heap.mat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kylin.jvm.lab.heap.util.Util;

public class HeapTestThread implements Runnable {
		
	private int id;
		
	List<BeanSerializer> list = new ArrayList<BeanSerializer>();

	public HeapTestThread(int id) {
		this.id = id ;
	}

	@SuppressWarnings("static-access")
	public void run() {

		Thread.currentThread().setName("heap-lab-" + id);
		
		BeanSerializer serializer = new BeanSerializer();
		DocResponse doc = new DocResponse();
		
		if(id == 10){
			byte[] buf = Util.getMBbyte(100);
			doc.setBuffer(buf);
			serializer.setResponse(doc);
			serializer.setContent(Util.getMBbyte(100));
		} else if(id % 3 == 0){
			byte[] buf = Util.getMBbyte(10);
			doc.setBuffer(buf);
			serializer.setResponse(doc);
			serializer.setContent(Util.getMBbyte(10));
		} else {
			byte[] buf = Util.getMBbyte(1);
			doc.setBuffer(buf);
			serializer.setResponse(doc);
			serializer.setContent(Util.getMBbyte(1));
		}
		
		list.add(serializer);
		
		System.out.println(Thread.currentThread().getName() + " is sleeping");
		
		try {
			Thread.currentThread().sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}

}
