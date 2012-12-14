package com.kylin.applepassing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.kylin.applepassing.consumer.AppleConsumer;
import com.kylin.applepassing.marker.AppleMarker;
import com.kylin.applepassing.producer.AppleProducer;
import com.kylin.applepassing.threads.MonitorThread;

public class Main {
	
	protected static final String LOGGER_FILE = "log4j.xml";
	
	private static final Logger logger = Logger.getLogger(Main.class);
	
	private static final int THREAD_COUNT = 50 ;
	private static final int SLEEP = 500;
	
	int capacity, threadCount, sleep;
	
	public Main(int capacity, int threadCount, int sleep) {
		this.capacity = capacity;
		this.threadCount = threadCount;
		this.sleep = sleep;
	}
	
	private Threshold threshold;
	
	private ExecutorService producedExecutor, markerExecutor, consumerExecutor;
	
	private MonitorThread monitorThread;
	
	public void start() {
		
		logger.info("Start Apple Passing");
		
		threshold = new Threshold(capacity);
		
		producedExecutor = Executors.newFixedThreadPool(threadCount);
		logger.info("Initialize a FixedThreadPool(Produce Thread Pool), fixed Thread number is " + threadCount);
		
		markerExecutor = Executors.newFixedThreadPool(threadCount);
		logger.info("Initialize a FixedThreadPool(Mark Thread Pool), fixed Thread number is " + threadCount);
	
		consumerExecutor = Executors.newFixedThreadPool(threadCount);
		logger.info("Initialize a FixedThreadPool(Consume Thread Pool), fixed Thread number is " + threadCount);
	
		for(int i = 0 ; i < threadCount ; i ++) {
			
			AppleProducer producer = new AppleProducer(threshold, i, sleep);
			producedExecutor.execute(producer);
			logger.info("Initialise a AppleProducer, add to thread pool");
			
			AppleMarker marker = new AppleMarker(threshold, i);
			markerExecutor.execute(marker);
			logger.info("Initialise a AppleMarker, add to thread pool");
			
			AppleConsumer consumer = new AppleConsumer(threshold, i);
			consumerExecutor.execute(consumer);
			logger.info("Initialise a AppleMarker, add to thread pool");
		}
		
		monitorThread = new MonitorThread(threshold, 0);
		new Thread(monitorThread).start();
	}

	public static void main(String[] args) {
		
		int capacity = 0, threadCount = 0, sleep = 0;

		for (int i = 0; i < args.length; i++) {

			if ("-c".equals(args[i])) {
				capacity = Integer.parseInt(args[++i]);
				continue;
			}
			
			if ("-t".equals(args[i])) {
				threadCount = Integer.parseInt(args[++i]);
				continue;
			}
			
			if ("-s".equals(args[i])) {
				sleep = Integer.parseInt(args[++i]);
				continue;
			}
			
			if ("-h".equals(args[i])) {
				prompt();
			}
		}
		
		DOMConfigurator.configure(LOGGER_FILE);
		
		if (threadCount == 0) {
			threadCount = THREAD_COUNT;
		}
		
		if(sleep == 0) {
			sleep = SLEEP;
		}
		
		new Main(capacity, threadCount, sleep).start();
	}

	private static void prompt() {
		System.out.println("ApplePassing Start parameter:");
		System.out.println("-c <Queue capacity>");
		System.out.println("-t <thread count>");
		System.out.println("-s <sleep interval>");
		System.out.println("An Example: [com.kylin.applepassing.Main -c 1000 -t 20 -s 500]");
		Runtime.getRuntime().exit(0);
	}

}
