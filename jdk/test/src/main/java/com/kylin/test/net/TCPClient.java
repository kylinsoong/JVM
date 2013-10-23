package com.kylin.test.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("127.0.0.1", 3873);
		OutputStream out = socket.getOutputStream();
		out.write("test".getBytes());
		out.flush();
		System.out.println("DONE");
	}

}
