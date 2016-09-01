package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ELExampServlet extends HttpServlet{
	
	String[] arr = {"Jbp", "Bhp", "Gwl", "Rip", "Ind", "Nag", "Kan"};

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		HttpSession hs = request.getSession();		
		
		
		getServletContext().setAttribute("cities", arr);

		RequestDispatcher view = request.getRequestDispatcher("nextpg.jsp");
		view.forward(request,response);
	}
}