package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class AnotherServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextPage = "login.jsp";

		User user = (User)session.getAttribute("user");

		if(user!=null){
			nextPage = "another.jsp";
		}else{
			request.setAttribute("msg", "Your session is expired... Sorry!");
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}