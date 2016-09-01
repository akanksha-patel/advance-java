package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		//1. Get Session
		HttpSession session = request.getSession();
		System.out.println(session.getId());

		//2. Set Next Page
		String nextPage = "profile.jsp";

		//3. Get All Parameters
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		//4. Validate Parameters
		boolean flag = true;
		String msg = "";

		if(email.trim().equals("")){
			flag = false;
			msg += "Email is required <br />";
		}

		if(password.trim().length()<6||password.trim().length()>15){
			flag = false;
			msg += "password must be >5 and <16 characters<br />";
		}

		//5. On Success:
		//Perform Login Action
		if(flag){
			User user = new User(email, password);
			if(user.loginUser()){
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(30);
			}else{
				nextPage = "login.jsp";
				msg += "Either Email or Password in invalid<br />";
				request.setAttribute("msg", msg);
			}
		}
		//6. On Fail
		//Forward back the login page
		else{
			nextPage = "login.jsp";
			request.setAttribute("msg", msg);
		}
		

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}