package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
//import java.util.*;

//import models.City;

public class ShowRegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		//ArrayList cities = City.collectCities();

		//request.setAttribute("cities", cities);

		request.getRequestDispatcher("register.jsp").forward(request,response);
	}
}




























