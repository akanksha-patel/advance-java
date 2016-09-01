package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import models.*;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		//1. Create Session
		HttpSession session = request.getSession();

		//2. Forward Page
		String nextPage = "login.jsp";

		//Get Parameters
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm_password");
		String genderId = request.getParameter("gender");
		String cityId = request.getParameter("city");
		
		//Validate Parameter information
		boolean flag = true;
		String msg = "";

		if(userName.trim().equals("")){
			flag = false;
			msg = msg + "User name required. <br />";
		}

		if(email.trim().equals("")){
			flag = false;
			msg = msg + "Email is required. <br />";
		}

		if(password.trim().equals("")){
			flag = false;
			msg = msg + "Password is mandatory. <br />";
		}

		if(password.trim().length()<6||password.trim().length()>15){
			flag = false;
			msg = msg + "Password must be greater than 5 character and less than 16 characters. <br />";
		}

		if(!password.trim().equals(confirmPassword.trim())){
			flag = false;
			msg = msg + "Password and Confirm Password must match. <br />";
		}

		if(genderId==null){
			flag = false;
			msg = msg + "Gender is mandatory. <br />";
		}

		if(cityId.equals("0")){
			flag = false;
			msg = msg + "City is required. <br />";
		}
		
		//If All OK - Register User
		if(flag){
			User user = new User();
			user.setUserName(userName);
			user.setEmail(email);
			user.setPassword(password);
			user.setGender(new Gender(Integer.parseInt(genderId)));
			user.setCity(new City(Integer.parseInt(cityId)));

			if(user.registerUser()){
				//-----------
			}else{
				msg = msg + "Duplicate email record inserted<br />";
				request.setAttribute("msg", msg);
				nextPage = "register.jsp";
			}
		}
		//Else - Send Error
		else{
			nextPage = "register.jsp";
			request.setAttribute("msg", msg);
		}

		//Forward to another page
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}