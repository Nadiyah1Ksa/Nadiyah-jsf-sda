package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			String Email = request.getParameter("Email");
			
			String pass = request.getParameter("Pass");
			 if(Email.equals(pass)) {
				 RequestDispatcher rd =  request.getRequestDispatcher("SuccessServiet");
			     rd.forward(request, response);
			 } else {
				 RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			      PrintWriter out = response.getWriter();
			      out.print("<html><body><p style = 'colore:red'>Invaild credentials</p></body></html>");
				 
				 rd.include(request, response);
			      
			 }
	}

}
