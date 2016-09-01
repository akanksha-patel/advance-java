package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.User;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String userName = request.getParameter("nm");
		String email = request.getParameter("em");
		String password = request.getParameter("pw");

		User user = new User(userName, email, password);
		if(user.registerUser()){
			String realPath = getServletContext().getRealPath("/WEB-INF/uploads");
			File file = new File(realPath, email);

			file.mkdir();
		}
	}
}