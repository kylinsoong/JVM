package com.kylin.jvm.lab.heap.mat;

import java.util.Random;

import com.kylin.jvm.lab.heap.util.Util;

public class HeapTestThread implements Runnable {
	
	private static final int T_THREAD = 20 ;
	
	private int id;
	
	private Threshold threshold;

	public HeapTestThread(int id, Threshold threshold) {
		this.id = id ;
		this.threshold = threshold ;
	}

	public void run() {

		Thread.currentThread().setName("heap-lab-" + id);
		
		BeanSerializer serializer = new BeanSerializer();
		DocResponse doc = new DocResponse();
		
		int i = new Random().nextInt(T_THREAD);
		if((i > 10) && (i % 2 == 0) && threshold.isSet()){
			threshold.setSet(false);
			String str = Util.getMBString(100);
			byte[] buf = Util.getMBbyte(150);
			doc.setBuffer(buf);
			serializer.setResponse(doc);
			serializer.setContent(str);
		} else if(i % 3 == 0){
			String str = Util.getKBString(100);
			byte[] buf = Util.getKBbyte(150);
			doc.setBuffer(buf);
			serializer.setResponse(doc);
			serializer.setContent(str);
		} else {
			String str = Util.getMBString(1);
			byte[] buf = Util.getMBbyte(1);
			doc.setBuffer(buf);
			serializer.setResponse(doc);
			serializer.setContent(str);
		}
		
		try {
			Thread.currentThread().sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		
	}

}
