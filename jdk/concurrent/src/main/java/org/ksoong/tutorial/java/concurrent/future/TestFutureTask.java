package org.ksoong.tutorial.java.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestFutureTask {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();
        
        Thread.sleep(1000);
      
        System.out.println("主线程在执行任务");
        
        System.out.println("task运行结果" + futureTask.get());
         
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
