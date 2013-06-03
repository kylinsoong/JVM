package com.kylin.jvm.thread.jboss;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testServlet
 */
public class CounterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public CounterServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-- " + Thread.currentThread().getName() + " request cunter start");
		int count = Counter.getCount();
		request.getSession().setAttribute("count", count);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		System.out.println("-- " + Thread.currentThread().getName() + " request cunter end : " + count);
	}

}
