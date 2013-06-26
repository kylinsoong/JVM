package com.kylin.jdk.socket.port.tcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPServerThread implements Runnable {
	
	private String ip;
	
	private int port;


	public UDPServerThread(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}


	public void run() {

		try {
			DatagramSocket serverSocket = new DatagramSocket(new InetSocketAddress(ip, port));
			System.out.println(Thread.currentThread().getName() + ", UDP Server Socket Start on " + serverSocket.getLocalSocketAddress());
			byte[] buf = new byte[1024];
			DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
			serverSocket.receive(receivePacket);
			receivePacket = new DatagramPacket(buf, buf.length);
			serverSocket.receive(receivePacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
