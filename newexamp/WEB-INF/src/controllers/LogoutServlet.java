package controllers;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.sql.Date;

import models.UserInfo;

public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();		
		
		session.invalidate();

		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
}