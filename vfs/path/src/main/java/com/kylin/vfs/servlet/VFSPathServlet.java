package com.kylin.vfs.servlet;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VFSPathServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1770304184548479022L;
	
		
	public VFSPathServlet() {
				
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tclasspath1 = VFSPathServlet.class.getResource("/").getPath();
		String tclasspath2 = VFSPathServlet.class.getClassLoader().getResource("").getPath();
		String tclasspath3 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		
//		System.out.println("tclasspath1: " + tclasspath1);
//		System.out.println("tclasspath2: " + tclasspath2);
//		System.out.println("tclasspath3: " + tclasspath3);
		

		URL test0 = Thread.currentThread().getContextClassLoader().getResource("/test0");
		System.out.println(test0.getPath());
		URL test1 = Thread.currentThread().getContextClassLoader().getResource("/com/test1");
		System.out.println(test1.getPath());
		URL test2 = Thread.currentThread().getContextClassLoader().getResource("/com/redhat/test2");
		System.out.println(test2.getPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
