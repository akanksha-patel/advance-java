package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class AdminPageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		//1. Get Session
		HttpSession session = request.getSession();
		System.out.println(session.getId());

		String nextPage = "login.jsp";

		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			int userTypeId = user.getUserType().getUserTypeId();
			if(userTypeId==1){
				nextPage = "adminpage.jsp";
			}else if(userTypeId==2||userTypeId==3){
				nextPage = "profile.jsp";
				request.setAttribute("msg", "don't try this again ... :<");
			}
		}else{
			request.setAttribute("msg", "Sorry! your session is expired..");
		}		

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}