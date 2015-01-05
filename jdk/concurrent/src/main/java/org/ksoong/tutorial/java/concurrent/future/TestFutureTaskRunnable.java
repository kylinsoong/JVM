package org.ksoong.tutorial.java.concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class TestFutureTaskRunnable {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Result result = new Result();
		Task task = new Task(result);
        FutureTask<Result> futureTask = new FutureTask<Result>(task, result);
        Thread thread = new Thread(futureTask);
        thread.start();
        
        Thread.sleep(1000);
        
        System.out.println("主线程在执行任务");
        
        System.out.println("task运行结果" + futureTask.get());
         
        System.out.println("所有任务执行完毕");

	}
	
	static class Result {
		public int result;

		@Override
		public String toString() {
			return result + "";
		}
	}
	
	static class Task implements Runnable {
		private Result result;

		public Task(Result result) {
			super();
			this.result = result;
		}

		@Override
		public void run() {
			System.out.println("子线程在进行计算");
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        int sum = 0;
	        for(int i=0;i<100;i++) {
	        	sum += i;
	        }
	        result.result = sum;
		}
		
	}

}
