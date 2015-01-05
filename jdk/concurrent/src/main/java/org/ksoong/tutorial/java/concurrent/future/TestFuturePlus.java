package org.ksoong.tutorial.java.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestFuturePlus {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();
        
        Thread.sleep(1000);
      
        System.out.println("主线程在执行任务");
        
        System.out.println("task isDone: " + result.isDone());
        System.out.println("task isCancelled: " + result.isCancelled());
        try {
			System.out.println("task运行结果" + result.get(1000, TimeUnit.MICROSECONDS));
		} catch (TimeoutException e) {
		}
        result.cancel(true);
        System.out.println("task isDone: " + result.isDone());
        System.out.println("task isCancelled: " + result.isCancelled());
        
        System.out.println("任务取消");
	}
	
	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			System.out.println("子线程在进行计算");
	        Thread.sleep(20000);
	        int sum = 0;
	        for(int i=0;i<100;i++) {
	        	sum += i;
	        }
	        return sum;
		}
		
	}

}
