package com.kylin.test.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {

	Socket socket = null;
	
	String[] sendArray = new String[]{"000899999999"
									, "01296002|27010102|20120828|121417|1231310|20120828000001357175||06251501010020120828|000000000017000|0|0100000012|2131231123|0002310|"
									, "0120000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"};

	public void start() {

		try {
			socket = new Socket("127.0.0.1", 9876);
			
//			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//		    byte[] data = sendArray[0].getBytes();
//		    dos.writeInt(data.length);
//		    dos.write(data);
//		    dos.flush();
			
			
			OutputStream out = socket.getOutputStream();
//			out.write(22);
			out.write(sendArray[1].getBytes());
			out.flush();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SimpleClient().start();
		System.out.println("Client Done");
	}

}
