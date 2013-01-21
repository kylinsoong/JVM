package com.kylin.jmx.jboss;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

import javax.naming.Context;
import javax.naming.InitialContext;

public class testjmx {
	
	private static String ip = "127.0.0.1" ;
	private static String port = "1099";


	public static void main(String[] args) throws Exception {
		
		parser(args);
		String url = "jnp://" + ip + File.pathSeparator + port ;
		System.out.println("Connect JBoss via " + url);
		
		Properties env = new Properties();

		env.setProperty(Context.SECURITY_PRINCIPAL, "admin");
		env.setProperty(Context.SECURITY_CREDENTIALS, "admin");

		env.setProperty("java.naming.factory.initial", "org.jboss.security.jndi.JndiLoginInitialContextFactory");
		env.setProperty("java.naming.provider.url", url);
		env.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
	        
		Context ctx;
	      
		try {
			ctx = new InitialContext(env);
			MBeanServerConnection server = (MBeanServerConnection)ctx.lookup("jmx/invoker/RMIAdaptor");
	            
			ObjectName ServerConfigMB = new ObjectName("jboss.system:type=ServerConfig");
	 
			// Get all MBeans    
			Set mbnameSet = server.queryNames(null, null);
			String key = null;
			ObjectName mBeanName;
			
			System.out.println("Print all MBeans");
			for (Iterator it = mbnameSet.iterator(); it.hasNext();) {
				key = "" + it.next();
				System.out.println("    " + key);
			}
			System.out.println("\nServerName=" + server.getAttribute(ServerConfigMB, ("ServerName")) + 
							   " JBossHomeDir=" + server.getAttribute(ServerConfigMB, ("HomeDir")) + 
							   " ServerHomeDir=" + server.getAttribute(ServerConfigMB, ("ServerHomeDir")));

		} catch (Exception e) {
			throw e ;
		}
	}


	private static void parser(String[] args) {
		
		for(int i = 0 ; i < args.length ; i ++) {
			if(args[i].equals("-b")) {
				ip = args[++i] ;
				continue ;
			} else if(args[i].equals("-p")) {
				port = args[++i] ;
				continue ;
			} else {
				help();
			}
		}
	}


	private static void help() {
		System.out.println("Run testjmx parameters format: [-b <IP>] [-p <PORT>]");
		System.out.println("Default bind ip: 127.0.0.1, default port: 1099");
		Runtime.getRuntime().exit(0);
	}
}


