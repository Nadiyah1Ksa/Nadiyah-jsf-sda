package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuccessServelt
 */
@WebServlet("/SuccessServelt")
public class SuccessServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	      out.print("<html><body>");
	      String Email =request.getParameter("Email");
	      out.print("<p style = 'colore:green'>Welcome"+ Email );
		   out.print("</html></body>");
	}

}
