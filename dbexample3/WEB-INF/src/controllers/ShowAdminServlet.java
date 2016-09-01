package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class ShowAdminServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "login.jsp";

		User user = (User)session.getAttribute("user");

		if(user!=null){
			if(user.getUserType().equals(2)){
				nextPage = "WEB-INF/webpgs/admin.jsp";
			}else{
				nextPage = "another.jsp";
				request.setAttribute("msg", "You are not supposed to visit this page!");
			}			
		}else{
			request.setAttribute("msg", "Your session is expired... Sorry!");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request,response);
	}
}