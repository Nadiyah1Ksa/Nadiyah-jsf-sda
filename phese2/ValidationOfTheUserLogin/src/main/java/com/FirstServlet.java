package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  System.out.println("First Sevlet starts");
	  PrintWriter out = response.getWriter();
	  out.println("<html><body><h3>firist servlet response <h3/></body></html>") ;
	  RequestDispatcher rd =request.getRequestDispatcher("SecondServlet");
	  rd.forward(request, response);
	  System.out.println("First Servlet ends");
	
	}
		
		
	

}
