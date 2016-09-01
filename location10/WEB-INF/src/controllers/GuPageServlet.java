package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class GuPageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		//1. Get Session
		HttpSession session = request.getSession();
		System.out.println(session.getId());

		String nextPage = "login.jsp";

		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			nextPage = "gupage.jsp";
		}else{
			request.setAttribute("msg", "Sorry! your session is expired..");
		}		

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}