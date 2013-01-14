package com.kylin.jdk.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	ServerSocket serverSocket = null;
	
	public void start(int port) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Server Socket Start on " + serverSocket.getInetAddress().getLocalHost().getHostName() + File.pathSeparator + serverSocket.getLocalPort() );
			Socket socket = serverSocket.accept();
			System.out.println(convertToString(socket.getInputStream()));
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String convertToString(InputStream in) throws IOException {
		
		InputStreamReader is = new InputStreamReader(in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(is);
		String read = br.readLine();

		while (read != null) {
			sb.append(read);
			read = br.readLine();
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		new SimpleServer().start(1099);
	}

}
