package com.kylin.test.util.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) throws InterruptedException {
		
		new SemaphoreTest().test();
		
	}
	
	private void test() throws InterruptedException {
		
		Pool pool = new Pool(10);
		
		for(int i = 0 ; i < 15 ; i ++) {
			pool.getItem();
		}
	}

	private class Pool {
		private int MAX_AVAILABLE = 0;
		private Semaphore available ;
		
		public Pool(int size){
			this.MAX_AVAILABLE = size;
			available = new Semaphore(MAX_AVAILABLE, true);
		}
		
		public Object getItem() throws InterruptedException{
			available.acquire();
			return getNextAvailableItem();
		}
		
		public void putItem(Object x) {
			if (markAsUnused(x)){
				available.release();
			}
		}
		
		protected Object[] items = new Object[MAX_AVAILABLE];
		protected boolean[] used = new boolean[MAX_AVAILABLE];

		protected synchronized boolean markAsUnused(Object item) {
			for (int i = 0; i < MAX_AVAILABLE; i++){
				if (item == items[i]){
					if (used[i]){
						used[i] = false;
						return true;
					} else {
						return false;
					}
				}
			}
			return false;
		}

		protected synchronized Object getNextAvailableItem() {
			for (int i = 0; i < MAX_AVAILABLE; i++){
				if (!used[i]) {
					used[i] = true;
					return items[i];
				}
			}
			return null;
		}
	}

}
