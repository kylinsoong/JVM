package com.kylin.jmx.jboss;

import java.util.Properties;

import javax.management.MBeanServerConnection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMXJNDIClient {

	public static void main(String[] args) {
		
		Properties env = new Properties();

        env.setProperty(Context.SECURITY_PRINCIPAL, "admin");
        env.setProperty(Context.SECURITY_CREDENTIALS, "admin");

        env.setProperty("java.naming.factory.initial", "org.jboss.security.jndi.JndiLoginInitialContextFactory");
        env.setProperty("java.naming.provider.url", "jnp://10.208.8.62:1049");
        env.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
        
        Context ctx;
        
        try {
			ctx = new InitialContext(env);
			MBeanServerConnection server = (MBeanServerConnection)ctx.lookup("jmx/invoker/RMIAdaptor");
			System.out.println(server);
        } catch (Exception e) {
			e.printStackTrace();
		}
	}

}
