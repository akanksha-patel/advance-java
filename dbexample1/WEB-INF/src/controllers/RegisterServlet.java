package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

import models.User;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession hs = request.getSession();

		String nextPage = null;

		String userName = request.getParameter("user_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");




		User user = new User(userName, email, password);
		//boolean flag = user.registerUser();

		if(user.registerUser()){
			nextPage = "login.jsp";
		}else{
			request.setAttribute("msg", "Duplicate Email!");
			nextPage = "register.jsp";
		}
		
		RequestDispatcher view = request.getRequestDispatcher(nextPage);
		view.forward(request,response);
	}
}