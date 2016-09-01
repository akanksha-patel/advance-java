package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		String nextPage = "register.jsp";
		
		String userName = request.getParameter("unm");
		String email = request.getParameter("eml");
		String password = request.getParameter("pwd");
		String repass = request.getParameter("repwd");
		
		//validation
		

		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);

		if(user.registerUser()){
			System.out.println("The User ID: "+user.getUserId());	
			UserInfo userInfo = new UserInfo(user);
			userInfo.registerUserInfo();
			nextPage = "login.jsp";
		}

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}