package com.kylin.jdk.socket.port.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketThread implements Runnable {
	
	private String ip;
	
	private int port;

	public ServerSocketThread(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		
		try {
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(ip, port));
			System.out.println(Thread.currentThread().getName() + ", Server Socket Start on " + serverSocket.getLocalSocketAddress() + ", block on read stream");
			Socket socket = serverSocket.accept();
			byte[] buf = new byte[1024];
			InputStream in = socket.getInputStream();
			in.read(buf);
		} catch (IOException e) {
			Thread.currentThread().interrupt();
		}
	}

}
