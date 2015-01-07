package org.ksoong.tutorial.java.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.ksoong.tutorial.java.concurrent.future.TestFuture.Task;

public class TestFutureTaskCancel {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> futureTask = executor.submit(task);
        
        Thread.sleep(1000);
      
        System.out.println("主线程在执行任务");
        
        
        System.out.println("task取消结果： " + futureTask.cancel(true));
         
        System.out.println("所有任务执行完毕");
	}
	
	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {
			System.out.println("子线程在进行计算");
			while(true){
				int sum = 0;
		        for(int i=0;i<100;i++) {
		        	sum += i;
		        }
		        Thread.sleep(1000);
			}
		}
		
	}

}
