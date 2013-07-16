package com.kylin.jvm.lab.heap;

import java.util.LinkedList;

public class HeapGCOverHead {
	
	public void run() {
		LinkedList<Object> holder = new LinkedList<Object>();
		while (true) {
			try {
				holder.add(new byte[128 * 1024]);
			} catch (OutOfMemoryError e) {
				holder.removeLast();
				e.printStackTrace();
				sleep(1000);
			}
		}
	}
	
	@SuppressWarnings("static-access")
	private void sleep(long interval) {
		try {
			Thread.currentThread().sleep(interval);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}


}
