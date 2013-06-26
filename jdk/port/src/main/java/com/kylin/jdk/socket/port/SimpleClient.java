package com.kylin.jdk.socket.port;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {

	Socket socket = null;
	
	final static String TEST_STR = "\n    Test TCP Comunication[java socketss] Success\n";

	public void start() {

		try {
			socket = new Socket("10.66.192.48", 9876);
//			System.out.println("Socket client connect to " + ip + ":" + port);
			
			byte[] buf = new byte[1024];
			InputStream in = socket.getInputStream();
			in.read(buf);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SimpleClient().start();
	}

}
