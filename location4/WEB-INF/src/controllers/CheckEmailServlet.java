package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;
import org.json.*;

public class CheckEmailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		
		String msg = "";
		if(User.checkEmail(email)){
			msg = "Account with this email already exists";
		}

		response.getWriter().write(msg);
	}
}