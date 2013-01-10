package com.kylin.vfs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloWorldServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1770304184548479022L;
	
	private static final Logger logger = Logger.getLogger(HelloWorldServlet.class);
		
	public HelloWorldServlet() {
				
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.info("HelloWorldServlet doGet");
		
		try {
			Class cls = Class.forName("com.kylin.vfs.lib.VFSTestImpl");
			cls.getConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException("", e);
		}
		
//		try {
//			Class cls = Class.forName("com.terracotta.express.ClientFactoryImpl");
//			cls.getConstructor().newInstance();
//		} catch (Exception e) {
//
//			throw new RuntimeException("", e);
//		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
