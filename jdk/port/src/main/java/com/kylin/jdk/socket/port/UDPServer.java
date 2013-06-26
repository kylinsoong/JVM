package com.kylin.jdk.socket.port;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPServer {

	public static void main(String[] args) throws IOException {

		DatagramSocket serverSocket = new DatagramSocket(new InetSocketAddress("10.66.192.48", 5430));
		System.out.println("UDP Server Socket Start on " + serverSocket.getLocalSocketAddress());
		byte[] buf = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
		serverSocket.receive(receivePacket);
		receivePacket = new DatagramPacket(buf, buf.length);
		serverSocket.receive(receivePacket);
	}

}
