package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "login.jsp";

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean flag = true;
		String msg = "";
		if(email.trim().equals("")){
			//msg = msg + "Email required..<br />";
			msg += "Email required..<br />";
			flag = false;
		}

		if(password.trim().equals("")){
			msg += "Password required..<br />";
			flag = false;
		}
		
		int pl = password.length();
		if(pl<6){
			msg += "Password must be at least 6 character length..<br />";
			flag = false;
		}

		if(flag){
			User user = new User(email, password);
			if(user.loginUser()){
				nextPage = "profile.jsp";
				session.setAttribute("user", user);
			}else{
				msg += "Invalid Email Password..<br />";	
				request.setAttribute("msg", msg);
			}			
		}else{
			request.setAttribute("msg", msg);
		}		
		
		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request,response);
	}
}