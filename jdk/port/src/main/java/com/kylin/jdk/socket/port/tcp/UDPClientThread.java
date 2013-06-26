package com.kylin.jdk.socket.port.tcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientThread implements Runnable {

	private String ip;

	private int port;

	public UDPClientThread(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public void run() {

		try {
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName(ip);
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			String sentence = "ping";
			sendData = sentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
