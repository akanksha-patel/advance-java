package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import models.*;

public class StateServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
							throws IOException,ServletException{
		int countryId = Integer.parseInt(request.getParameter("countryid"));	

		ArrayList states = State.collectStates(countryId);

		request.setAttribute("states", states);

		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}