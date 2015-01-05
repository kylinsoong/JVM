package org.ksoong.tutorial.java.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class TestFutureTaskPlus {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();
        
        Thread.sleep(1000);
      
        System.out.println("主线程在执行任务");
        
        System.out.println("task 是否结束: " + futureTask.isDone());
        System.out.println("task 是否取消: " + futureTask.isCancelled());
        try {
			System.out.println("task运行结果" + futureTask.get(1000, TimeUnit.MICROSECONDS));
		} catch (TimeoutException e) {
		}
        futureTask.cancel(true);
        System.out.println("task 是否结束: " + futureTask.isDone());
        System.out.println("task 是否取消: " + futureTask.isCancelled());
        
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
