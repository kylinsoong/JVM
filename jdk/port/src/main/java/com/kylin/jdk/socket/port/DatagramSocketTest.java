package com.kylin.jdk.socket.port;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class DatagramSocketTest {

	public static void main(String[] args) throws SocketException {

		DatagramSocket serverSocket = new DatagramSocket(new InetSocketAddress("228.10.10.10", 55588));
	}

}
