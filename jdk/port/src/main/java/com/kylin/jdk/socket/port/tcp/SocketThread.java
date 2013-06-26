package com.kylin.jdk.socket.port.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketThread implements Runnable {

	private String ip;

	private int port;

	public SocketThread(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public void run() {

		try {
			Socket socket = new Socket(ip, port);
			System.out.println(Thread.currentThread().getName() + ", Socket client connect to " + ip + ":" + port);
			byte[] buf = new byte[1024];
			InputStream in = socket.getInputStream();
			in.read(buf);
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
