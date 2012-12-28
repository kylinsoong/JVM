package com.kylin.jvm.lab;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class JVMCrashTestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(JVMCrashTestServlet.class);
   
    public JVMCrashTestServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("-- test JVM Crash start");
		TestClass.printHello();
		getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		logger.info("-- test JVM Crash end");
	}

}
