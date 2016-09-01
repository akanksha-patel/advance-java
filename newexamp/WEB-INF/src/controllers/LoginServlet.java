package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "login.jsp";
		
		String email = request.getParameter("eml");
		String password = request.getParameter("pwd");

		//validation

		User user = new User(email, password);		
		if(user.loginUser()){
			nextPage = "profile.jsp";
			UserInfo userInfo = new UserInfo(user);
			userInfo.collectUserDetails();
			session.setAttribute("user_info", userInfo);
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}