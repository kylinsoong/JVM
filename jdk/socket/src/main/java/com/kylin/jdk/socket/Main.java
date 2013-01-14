package com.kylin.jdk.socket;

public class Main {

	public static void main(String[] args) {
		
		boolean isSetRole = false, isSetIP = false, isSetPort = false;
		
		String role = "";
		String ip = "";
		int port = 1099;

		for(int i = 0 ; i < args.length ; i ++) {
			if("server".equals(args[i])) {
				isSetRole = true;
				role = "server";
			} else if("client".equals(args[i])) {
				isSetRole = true;
				role = "client";
			} else if("-b".equals(args[i])) {
				isSetIP = true;
				ip = args[++i] ;
			} else if("-p".equals(args[i])) {
				isSetPort = true;
				port = Integer.parseInt(args[++i]);
			} 
		}
		
		if(isSetRole && isSetIP && isSetPort) {
			if(role.equals("server")) {
				new SimpleServer().start(port);
			} else {
				new SimpleClient().start(ip, port);
			}
		} else {
			usage();
		}
	}

	private static void usage() {
		System.out.println("Run Test like: ");
		System.out.println("			 java -jar socket-conn.jar <role> <-b> <ip> <-p> <port>");
	}

}
