package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class ActivateAccountServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		//1. Get Session
		HttpSession session = request.getSession();

		String activationCode = request.getParameter("actcode");
		String email = request.getParameter("email");

		boolean flag = User.checkAccountStatus(email, activationCode);

		if(flag){
			User.activateAccount(email);
			request.setAttribute("scmsg", "Your Account activated succefully");
		}
		
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
}