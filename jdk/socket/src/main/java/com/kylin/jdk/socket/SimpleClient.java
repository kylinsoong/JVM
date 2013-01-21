package com.kylin.jdk.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {

	Socket socket = null;
	
	final static String TEST_STR = "\n    Test TCP Comunication[java socketss] Success\n";

	public void start(String ip, int port) {

		try {
			socket = new Socket(ip, port);
			
			OutputStream out = socket.getOutputStream();
			out.write(TEST_STR.getBytes());
			out.flush();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SimpleClient().start("127.0.0.1", 1099);
	}

}
