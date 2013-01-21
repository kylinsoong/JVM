package com.kylin.jdk.socket;

import java.io.File;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	ServerSocket serverSocket = null;
	
	@SuppressWarnings("static-access")
	public void start(int port) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Server Socket Start on " + serverSocket.getInetAddress().getLocalHost().getHostName() + File.pathSeparator + serverSocket.getLocalPort() );
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
		new SimpleServer().start(1099);
	}

}
