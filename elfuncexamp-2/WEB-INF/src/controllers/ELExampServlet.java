package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ELExampServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		HttpSession hs = request.getSession();		
		


		RequestDispatcher view = request.getRequestDispatcher("nextpg.jsp");
		view.forward(request,response);
	}
}