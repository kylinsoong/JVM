package com.kylin.jdk.socket.port;

import java.io.File;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	ServerSocket serverSocket = null;
	
	@SuppressWarnings("static-access")
	public void start() {
		try {
			ServerSocket serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("10.66.192.48", 9876));
			System.out.println("Server Socket Start on " + serverSocket.getLocalSocketAddress());
			Socket socket = serverSocket.accept();
			
			byte[] buf = new byte[1024];
			InputStream in = socket.getInputStream();
			in.read(buf);
			
			System.out.println(new String(buf));
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SimpleServer().start();
	}

}
