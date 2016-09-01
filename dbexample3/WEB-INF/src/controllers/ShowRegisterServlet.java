package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ShowRegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession hs = request.getSession();

		
		
		RequestDispatcher view = request.getRequestDispatcher("register.jsp");
		view.forward(request,response);
	}
}