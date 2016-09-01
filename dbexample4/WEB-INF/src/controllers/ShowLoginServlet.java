package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ShowLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession hs = request.getSession();

		
		
		RequestDispatcher view = request.getRequestDispatcher("login.jsp");
		view.forward(request,response);
	}
}