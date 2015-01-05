package org.ksoong.tutorial.java.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();
        
        Thread.sleep(1000);
      
        System.out.println("主线程在执行任务");
        
        System.out.println("task运行结果" + result.get());
         
        System.out.println("所有任务执行完毕");
	}
	
	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			System.out.println("子线程在进行计算");
	        Thread.sleep(5000);
	        int sum = 0;
	        for(int i=0;i<100;i++) {
	        	sum += i;
	        }
	        return sum;
		}
		
	}

}
