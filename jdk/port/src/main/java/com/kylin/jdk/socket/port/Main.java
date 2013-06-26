package com.kylin.jdk.socket.port;

import com.kylin.jdk.socket.port.tcp.ServerSocketThread;
import com.kylin.jdk.socket.port.tcp.SocketThread;
import com.kylin.jdk.socket.port.tcp.UDPClientThread;
import com.kylin.jdk.socket.port.tcp.UDPServerThread;

public class Main {

	public static void main(String[] args) {
				
		String ip = "127.0.0.1";
		int num = 1;
		int tcp_port = 9870;
		int udp_port = 5430;

		for(int i = 0 ; i < args.length ; i ++) {
			if("-b".equals(args[i])) {
				ip = args[++i] ;
				continue;
			} else if("-n".equals(args[i])) {
				num = Integer.parseInt(args[++i]) ;
				continue;
			} else {
				usage();
			}
		}
		
		for(int i = 0 ; i < num ; i ++) {
			new Thread(new ServerSocketThread(ip, tcp_port + i)).start();
			new Thread(new UDPServerThread(ip, udp_port + i)).start();
		}
		
		for(int i = 0 ; i < num ; i ++) {
			new Thread(new SocketThread(ip, tcp_port + i)).start();
			new Thread(new UDPClientThread(ip, udp_port + i)).start();
		}
		
	}

	private static void usage() {
		System.out.println("Run TCP/UDP port demo like: ");
		System.out.println("			 java -jar jdk-socket-port.jar -b <IP> -n <integer>");
		Runtime.getRuntime().exit(0);
	}

}
