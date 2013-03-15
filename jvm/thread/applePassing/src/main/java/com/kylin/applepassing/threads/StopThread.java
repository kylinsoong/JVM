package com.kylin.applepassing.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.kylin.applepassing.ThreadBase;
import com.kylin.applepassing.Threshold;
import com.kylin.applepassing.consumer.AppleConsumer;
import com.kylin.applepassing.marker.AppleMarker;
import com.kylin.applepassing.producer.AppleProducer;

public class StopThread extends ThreadBase implements Runnable {
	
	private List<AppleProducer> producerList ;
	private List<AppleMarker> markerList ;
	private List<AppleConsumer> consumerList ;
	private MonitorThread monitorThread;

	public StopThread(Threshold threshold, int threadId, List<AppleProducer> producerList, List<AppleMarker> markerList, List<AppleConsumer> consumerList, MonitorThread monitorThread) {
		super(threshold, threadId);
		this.producerList = producerList;
		this.markerList = markerList;
		this.consumerList = consumerList;
		this.monitorThread = monitorThread;
	}

	public String getName() {
		return "ApplePassing-Stop";
	}

	public void run() {

		while(true) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String msg = br.readLine();
				if(msg.equals("exit") || msg.equals("quit") || msg.equals("q!")) {
					System.out.println("Start Stop Thread...");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Stop Producer Threads");
		for(AppleProducer producer : producerList) {
			producer.stop();
			System.out.println("    Stop " + producer.getName());
		}
		
		System.out.println("Stop Marker Threads");
		for(AppleMarker marker : markerList) {
			marker.stop();
			System.out.println("    Stop " + marker.getName());
		}
		
		System.out.println("Stop Consumer Threads");
		for(AppleConsumer consumer : consumerList) {
			consumer.stop();
			System.out.println("    Stop " + consumer.getName());
		}
		
		System.out.println("Stop Monitor Thread");
		monitorThread.stop();
		System.out.println("    Stop " + monitorThread.getName());
	}

}
