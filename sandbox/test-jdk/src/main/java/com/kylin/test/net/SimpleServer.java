package com.kylin.test.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	private static final int SERVER_PORT = 10085;
	
	ServerSocket serverSocket = null;
	
	public void start() {
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server Socket Start on " + serverSocket.getLocalPort() + ", Waiting for client to connect ...");
			
			while(true) {
				Socket socket = serverSocket.accept();
//				BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
//				ObjectInputStream ois = new ObjectInputStream(bis);
				
				System.out.println(convertToString(socket.getInputStream()));
			}
			
			
			
			// read InputStream directly
//			System.out.println(convertToString(socket.getInputStream()));
			
			
//			int len = dis.readInt();
//		    byte[] data = new byte[len];
//		    dis.read(data);
//		    System.out.println(len + " " + new String(data));
		    
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
		new SimpleServer().start();
	}

}
